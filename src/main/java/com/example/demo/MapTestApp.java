package com.example.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class MapTestApp {
  public static void main(String[] args) {
    Map<String, String> books = new HashMap<>();
    books.put(
        "978-0201633610", "Design patterns : elements of reusable object-oriented software");
    books.put(
        "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
    books.put("978-0134685991", "Effective Java");
    Optional<String> first = books.entrySet().stream().filter(e -> "Effective Java".equals(e.getValue()))
        .map(Map.Entry::getKey)
        .findFirst();
    System.out.println("test : " + first.get());

    Iterator<Map.Entry<String, String>> iterator = books.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = iterator.next();
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    books.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
  }

}
