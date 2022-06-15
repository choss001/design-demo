package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class finalArrayTest {

  @Test
  void test1() {
    final int[] testArray= {1,2,3};

    log.info("test : {}", testArray[0]);
    testArray[0] = 5;
    log.info("test : {}", testArray[0]);


  }

}
