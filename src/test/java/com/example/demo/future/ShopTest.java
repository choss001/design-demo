package com.example.demo.future;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static com.example.demo.future.DelayUtil.delay;
import static java.util.stream.Collectors.*;
import static org.assertj.core.util.Arrays.asList;
import static org.assertj.core.util.Arrays.prepend;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

  List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
      new Shop("MyFavoriteShop"),
      new Shop("MyFavoriteShop"),
      new Shop("MyFavoriteShop"),
      new Shop("MyFavoriteShop"),
      new Shop("MyFavoriteShop"),
      new Shop("MyFavoriteShop"),
      new Shop("BuyItAll"));

  private final Executor executor =
      Executors.newFixedThreadPool(Math.min(shops.size(), 100),
          new ThreadFactory() {
    @Override
    public Thread newThread(Runnable r) {
      Thread t = new Thread(r);
      t.setDaemon(true);
      return t;
    }
  });

  @Test
  void test() {
    Shop shop = new Shop("Best Shop");
    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Invocation returned after " + invocationTime + " msecs ");
    doSomethingElse();
    try {
      double price = futurePrice.get();
      System.out.printf("Price is %.2f%n", price);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Price returned after " + retrievalTime + " msecs");

  }

  private void doSomethingElse() {
    delay();
  }

  @Test
  void parallelStreamTest() {
    long start = System.nanoTime();
    findPrices("myPhone275");
    System.out.println(findPrices("myPhone275"));
    long duration = (System.nanoTime() - start) / 1_000_000;
    System.out.println("Done in " + duration + " msecs");
  }


  @Test
  @DisplayName("패러렐 스트림보다 좋은 컴플리트 퓨처버전")
  void completeFutureTest() {
    long start = System.nanoTime();
    findPrices("myPhone275");
    System.out.println(findPricesCompletableFuture("myPhone275"));
    long duration = (System.nanoTime() - start) / 1_000_000;
    System.out.println("Done in " + duration + " msecs");
  }

  @Test
  @DisplayName("패러렐 스트림보다 좋은 컴플리트 퓨처버전의 더 좋은 custom executor 버전")
  void completeFutureCustomExecutorTest() {
    long start = System.nanoTime();
    findPrices("myPhone275");
    System.out.println(findPricesCompletableFutureCustom("myPhone275"));
    long duration = (System.nanoTime() - start) / 1_000_000;
    System.out.println("Done in " + duration + " msecs");
  }

  private List<String> findPrices(String product) {
    return shops.parallelStream().map(shop -> String.format("%s price is %.2f",
            shop.getName(), shop.getPrice(product)))
        .collect(toList());
  }

  private List<String> findPricesCompletableFuture(String product) {
    List<CompletableFuture<String>> priceFutures = shops.parallelStream().map(shop -> CompletableFuture.supplyAsync(
            () -> shop.getName() + " price is " +
                shop.getPrice(product)))
        .collect(toList());
    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(toList());
  }

  private List<String> findPricesCompletableFutureCustom(String product) {
    List<CompletableFuture<String>> priceFutures =
        shops.parallelStream().map(shop -> CompletableFuture.supplyAsync(
            () -> shop.getName() + " price is " +
                shop.getPrice(product), executor))
        .collect(toList());
    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(toList());
  }

  @Test
  void parallelStreamTest1() {
    shops.stream().forEach(i -> System.out.println("test : " + i.getName() + " ??? : " + i.getPriceAsync("product")));
  }

}