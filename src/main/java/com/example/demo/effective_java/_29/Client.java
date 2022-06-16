package com.example.demo.effective_java._29;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Client {
  public static void main(String[] args) {
//    Stack stack = new Stack();
//
//    log.info("isEmpty boolean : {} ",stack.isEmpty());
//
//    stack.push(1);
//    int size = 0;
//    size ++;
//    size ++;
//    log.info("size : {}", size);

    List<String> StrList = Arrays.asList("abc", "test", "why", "lambda");
    GenericStack<String> stack = new GenericStack<>();
    for (String arg : StrList)
      stack.push(arg);
    while(!stack.isEmpty())
      System.out.println(stack.pop().toUpperCase());

  }
}
