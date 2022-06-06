package com.example.demo.compleatbleFuture;

import static com.example.demo.future.DelayUtil.delay;

import java.awt.RadialGradientPaint;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shop {
  private String shopName;
  public Shop(String shopName) {
    this.shopName = shopName;
  }

  private static Random random = new Random();

  public double getPrice(String product) {
    return calculatePrice(product);
  }
  private double calculatePrice(String product) {

    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public Future<Double> getPriceAsync(String product) {
    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
    new Thread(() -> {
      log.info("getPriceAsync Thread");
      double price = calculatePrice(product);
      futurePrice.complete(price);
      log.info("getPriceAsync Thread end");
    }).start();
    log.info("getPriceAsync Thread second");
    return futurePrice;
  }
    public static void delay () {
      try {
        Thread.sleep(1000L);

      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

}