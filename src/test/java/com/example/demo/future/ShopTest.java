package com.example.demo.future;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static com.example.demo.future.DelayUtil.delay;
import static java.util.stream.Collectors.*;
import static org.assertj.core.util.Arrays.asList;
import static org.assertj.core.util.Arrays.prepend;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

  private final static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
          new Shop("MyFavoriteShop"),
          new Shop("LetsSaveBig"),
          new Shop("BuyItAll"));

  private final static String PRODUCT = "product";

  @Test
  void test() {
    Shop shop = new Shop("Best Shop");
    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Invocation returned after " + invocationTime + " msecs ");
    doSomethingElse();
    try{
      double price = futurePrice.get();
      System.out.printf("Price is %.2f%n", price);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Price returned after " + retrievalTime + " msecs");

  }

  private void doSomethingElse(){
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

  private List<String> findPrices(String product) {
    return shops.parallelStream().map(shop -> String.format("%s price is %.2f",
                    shop.getName(), shop.getPrice(product)))
            .collect(toList());
  }

  @Test
  void parallelStreamTest1() {
    shops.stream().forEach(i -> System.out.println("test : "+ i.getName() + " ??? : " + i.getPriceAsync("product")));
  }

  @Test
  void completableFuture() {
    shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(
                    () -> String.format("%s price is %.2f",
                            shop.getName(), shop.getPrice(PRODUCT))))
                    .collect(toList());
  }

}