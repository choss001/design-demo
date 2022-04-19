package com.example.demo.test;

import com.example.demo.lambda.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Slf4j
public class TestEx04 {

  private final static MessageDigest messageDigest;

  static {
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public TestEx04() throws NoSuchAlgorithmException {
  }

  public static void main(String[] args) {
    List<String> friends = Arrays.asList("tes", "te", "s");
    List<String> friendsL = List.of("A", "B", "C");
    friends.set(0, "!!!");
    log.info("test !! : {}", friends);

//    Character.isDigit(transaction)
    List<Transaction> transactions = new ArrayList<>();

    for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext(); ) {

    }
    for (int i = 0; i < 0; ) {

    }

    friends.stream().forEach(i -> i = "변경");
    log.info("test : {}", friends);

    log.info("test1 : {}", friends);

    Map<String, byte[]> dataToHash = new HashMap<>();
    friendsL.forEach(line -> dataToHash.computeIfAbsent(line, TestEx04::calculateDigest));
    log.info("dataToHash : {}", dataToHash);
    int aInt = 2;
    int bInt = 2;
    String a = "test";
    String b = "test";
    if(a == b){
      System.out.println("wow!!");
    }else{
      System.out.println("haha!");
    }
  }

  private static byte[] calculateDigest(String key) {
    return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
  }
}
