package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TestEx01 {
  public static void main(String[] args) {
//        String resultList = Arrays.asList(0, 0, 0, 0).stream()
//                .map(i -> (int) (Math.random() * 10))
//                .map(String::valueOf)
//                .collect(joining());
//        String resultList = Stream.of(0, 0, 0, 0)
//                .map(i -> (int)(Math.random() * 10))
//                .map(String::valueOf)
//                .collect(joining());
//        log.info("test4 {}", resultList);
//        List<Integer> test = IntStream.range(0 ,4)
//            .mapToObj(i -> i)
//            .collect(toList());
//        log.info("test :{}", test);
    String test = "[스마트 세이브] 인증번호를 입력해주세요 [4293]";
    Pattern patten1 = Pattern.compile("\\d{1,4}");
    Matcher matcher = patten1.matcher(test);
    log.info("boolean : {}", matcher.find());
    log.info("이거 되나?? : {} ", matcher.group());
    log.info("test: {} ", Math.sqrt(9) % 1 == 0);

  }
}
