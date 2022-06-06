package com.example.demo.compleatbleFuture;

import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ShopTest {

  @Test
  void test() {
    Shop shop = new Shop("BestShop");
    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    log.info("Invocation returned after {} msecs", invocationTime);
    doSomethingElse();
    log.info("somethingElse end !!!");
    try {
      double price = futurePrice.get();
      log.info("price is {} ", price);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    log.info("Price returned  after {} mescs", retrievalTime);
  }

  private void doSomethingElse() {
    log.info("doSomethingElse !!!");
//    Shop.deleay();
  }

}