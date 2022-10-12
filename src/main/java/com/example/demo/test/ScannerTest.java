package com.example.demo.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerTest {

  public static void main(String[] args) {

    System.out.printf("pattern matches test : %b%n", Pattern.matches("[amn]", "abcd"));
    System.out.printf("pattern matches test : %b%n", Pattern.matches("[amn]", "a"));
    System.out.printf("pattern matches test : %b%n", Pattern.matches("[amn]", "ammmm"));
    while (true) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter regex pattern");
      Pattern pattern = Pattern.compile(sc.nextLine());
      System.out.println("Enter Text");
      Matcher matcher = pattern.matcher(sc.nextLine());
      boolean found = false;
      while (matcher.find()) {
        System.out.println("I found the text " + matcher.group() + " starting at index " +
            matcher.start() + " and ending at index " + matcher.end());
        found = true;
      }
      if (!found) {
        System.out.println("No match found");
      }
    }
  }
}
