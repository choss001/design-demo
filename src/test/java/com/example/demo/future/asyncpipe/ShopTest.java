package com.example.demo.future.asyncpipe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.stream.Collectors.toList;

class ShopTest {

  final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
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
  void test(){
    Shop shop = new Shop("test");
    System.out.println(shop.getPrice("test"));
  }

  @Test
  void test1() {
    System.out.println(findPrices("test"));
    System.out.println("!!");
  }
  private List<String> findPrices(String product){
    return shops.stream()
        .map(shop -> shop.getPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(toList());
  }
  @Test
  void test2(){
    System.out.println(findPricesFuture("test"));
  }

  private List<String> findPricesFuture(String product){
    List<CompletableFuture<String>> priceFutures =
        shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getPrice(product), executor))
            .map(future -> future.thenApply(Quote::parse))
            .map(future -> future.thenCompose(quote ->
                CompletableFuture.supplyAsync(
                    () -> Discount.applyDiscount(quote), executor)))
            .collect(toList());

    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(toList());
  }

}