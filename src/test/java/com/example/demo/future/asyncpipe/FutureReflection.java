package com.example.demo.future.asyncpipe;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureReflection {

  private Shop shop = new Shop("product");
  ExecutorService executor = Executors.newCachedThreadPool();
  final Future<Double> futureRate = executor.submit(new Callable<Double>(){
    public Double call() {
      ExchangeService exchangeService = new ExchangeService();
      return exchangeService.getRate(Money.EUR, Money.USD);
    }
  });

  Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() {
    @Override
    public Double call() throws Exception {
      double priceInEUR = shop.getPrice("product");
      return priceInEUR * futureRate.get();
    }
  });

  public enum Money{
    EUR(5), USD(10);
    private final Integer percent;
    Money(Integer percent){
      this.percent = percent;
    }
  }


  @Test
  void futureReflection(){

  }
  static class ExchangeService{
    public Double getRate(Money eur, Money usd){
      return 15d;
    }
  }

}
