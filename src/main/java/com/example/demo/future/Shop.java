package com.example.demo.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.example.demo.future.DelayUtil.*;


public class Shop {

  public Shop(String name) {
    this.name = name;
  }

  private Random random=new Random();
  private String name;

  public String getName() {
    return name;
  }

  public Future<Double> getPriceAsync(String product) {
//    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//    new Thread(() -> {
//      try {
//        double price = calculatePrice(product);
//        futurePrice.complete(price);
//      } catch (Exception e) {
//        futurePrice.completeExceptionally(e);
//      }
//    }).start();
//    return futurePrice;
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }

  public double getPrice(String product){
    return calculatePrice(product);
  }

  private double calculatePrice(String product) {
    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }
}
