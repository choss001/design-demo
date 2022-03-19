package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Slf4j
public class TestEx03 {
  public static void main(String[] args) {
    Stream<int[]> stream = IntStream.range(1, 101).boxed()
        .flatMap(a ->
            IntStream.range(a, 101)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        );

    stream.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    long uniqueWords = 0;
    try(Stream<String> lines = Files.lines(Paths.get("/home/joseongsik/Desktop/memo.text"), Charset.defaultCharset())) {
      List<String> collect = lines.flatMap(line -> Arrays.stream(line.split(" "))).collect(toList());
      log.info("test!! : {}", collect);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Stream.iterate(new int[] {0, 1}, t -> new int[]{t[1], t[0]+t[1]} )
        .limit(20)
        .forEach(t -> System.out.println("(" +t[0] + "," + t[1] + ")"));
  }
}
