package com.example.demo.test;

import com.example.demo.lambda.Trader;
import com.example.demo.lambda.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Slf4j
public class TestEx02 {
  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2021, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );


    int result = transactions.stream().mapToInt(Transaction::getValue).sum();
    log.info("test : {} " ,result);

    transactions.stream().mapToInt(Transaction::getValue).max();
    int totalCalories = transactions.stream().collect(reducing(0, Transaction::getValue, Integer::sum));
    log.info("!!!: {}", totalCalories);



  }
}





