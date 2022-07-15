package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Slf4j
public class ArraysStream {
  @Test
  void test1(){
    String[] arr = {"Geeks", "for", "Geeks"};

    Stream<String> stream = Arrays.stream(arr);

    stream.forEach(str -> System.out.println(str + " "));

  }

  @Test
  void test2(){
    Stream stream = Stream.of("Geeks", "for", "Geeks");

    stream.forEach(str -> System.out.println(str + " "));
  }

  @Test
  void test3(){
    int arr[] = {1, 2, 3, 4, 5};

    IntStream intStream = Arrays.stream(arr);
//    intStream.forEach(str -> System.out.println(str + " "));
    OptionalDouble average = intStream.average();
    log.info("value : {}", average.orElse(0));
    Stream<int[]> stream = Stream.of(arr);

    stream.forEach(str -> System.out.println(str + " "));
  }
}
