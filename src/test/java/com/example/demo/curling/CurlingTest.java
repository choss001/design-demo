package com.example.demo.curling;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;

@Slf4j
public class CurlingTest {

  @Test
  void test() {

    log.info("converter : {}", converter(5, 6, 7));
    log.info("converter : {}", converter(4, 6, 7));

    log.info("converter : {}", curriedConverter(6, 7).applyAsDouble(5));

  }

  static double converter(double x, double f, double b) {
    return x * f + b;
  }

  static DoubleUnaryOperator curriedConverter(double f, double b) {
    return (double x) -> x * f + b;
  }
}
