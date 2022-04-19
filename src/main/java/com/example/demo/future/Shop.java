package com.example.demo.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.example.demo.future.DelayUtil.*;


public class Shop {

  public Shop(String product) {
    this.product = product;
  }

  private Random random=new Random();
  private String product;

  public Future<Double> getPriceAsync(String product) {
    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
    new Thread(() -> {
      double price = calculatePrice(product);
      futurePrice.complete(price);
    }).start();
    return futurePrice;
  }

  private double calculatePrice(String product) {
    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }
}
