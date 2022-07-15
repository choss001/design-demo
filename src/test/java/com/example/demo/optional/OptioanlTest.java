package com.example.demo.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptioanlTest {

  @Test
  void test1() {
    Optional<Object> nullOptional = Optional.ofNullable(null);
    Optional<Object> empty = Optional.empty();

  }
}
