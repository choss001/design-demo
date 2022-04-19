package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;


class ForkJoinSumCalculatorTest {

  @Test
  void test() {
    System.out.println("ForkJoin sum done in: " +
        measureSumPerf(ForkJoinSumCalculator::forkJoinSum,
            10_000_000) + " msecs");
  }

  private Long measureSumPerf(Function<Long, Long> forkJoinSumFunction, long numbers) {
    long start = System.currentTimeMillis();
    System.out.println("forkJoinSumFunction value : " + forkJoinSumFunction.apply(numbers));
    long end = System.currentTimeMillis();
    return end - start;
  }

  @Test
  void future(){

  }

}