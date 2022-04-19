package com.example.demo.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;

import static com.example.demo.future.DelayUtil.delay;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

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

}