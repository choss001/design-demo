package com.example.demo.future.asyncpipe;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.example.demo.future.DelayUtil.delay;

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
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }

  public String getPrice(String product){
    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
    return String.format("%s:%.2f:%s", name, price, code);
  }

  private double calculatePrice(String product) {
    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

}
