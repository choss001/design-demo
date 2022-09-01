package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
public class OrElseTest {
  private final static List<String> names = Arrays.asList("test1", "test2");


  @Test
  void test() {

    String name = Optional.of("baeldung")
        .orElse(getRandomName());
    log.info("return name : {}", name);
  }

  @Test
  void test1() {
    String name = Optional.of("baeldung")
        .orElseGet(() -> getRandomName());

    log.info("return name : {}", name);
  }

  public String getRandomName() {
    log.info("getRandomName() method - start");

    Random random = new Random();
    int index = random.nextInt(2);

    log.info("getRandomName() method - end");
    return names.get(index);
  }

}
