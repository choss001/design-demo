package com.example.demo.future.asyncpipe;

import static java.lang.Thread.sleep;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class FutureReflection {
  private static final Double DEFAULT_RATE = 10d;

  final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
    new Shop("MyFavoriteShop"),
    new Shop("BuyItAll"));

  private Shop shop = new Shop("product");
  ExecutorService executor = Executors.newCachedThreadPool();
  final Future<Double> futureRate = executor.submit(new Callable<Double>(){
    public Double call() {
      ExchangeService exchangeService = new ExchangeService();
      return exchangeService.getRate(Money.EUR, Money.USD);
    }
  });

  Future<Double> futurePriceInUSD = CompletableFuture.supplyAsync(() -> shop.getPriceDouble("product"))
    .thenCombine(
      CompletableFuture.supplyAsync(
        () -> new ExchangeService().getRate(Money.EUR, Money.USD))
        .completeOnTimeout(DEFAULT_RATE, 1, TimeUnit.SECONDS),
      (price, rate) -> price * rate
    )
    .orTimeout(3, TimeUnit.SECONDS);

  public enum Money{
    EUR(5), USD(10);
    private final Integer percent;
    Money(Integer percent){
      this.percent = percent;
    }
  }

  public Stream<CompletableFuture<String>> findPricesStream(String product) {
    return shops.stream()
      .map(shop -> CompletableFuture.supplyAsync(
        () -> shop.getPriceDouble(product), executor))
      .peek(System.out::println)
      .map(future -> future.thenApply(Quote::doubleFromParse))
      .peek(System.out::println)
      .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
        () -> Discount.applyDiscount(quote), executor)))
      .peek(System.out::println);
  }


  @Test
  void futureReflection(){
    findPricesStream("myPhone")
      .peek(System.out::println)
      .map(f -> f.thenAccept(System.out::println));

  }

  static class ExchangeService{
    public Double getRate(Money eur, Money usd){
      return 15d;
    }
  }

  private static final Random random = new Random();
  public static void randomDelay(){
    int delay = 500 + random.nextInt(2000);
    try{
      sleep(delay);
    }catch(InterruptedException e ){
      throw new RuntimeException(e);
    }
  }

}
