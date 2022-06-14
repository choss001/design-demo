package com.example.demo.object._01._04;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Slf4j
public class Client {
  public static void main(String[] args) {

    Movie titanic = new Movie("타이타닉",
        Duration.ofMinutes(180),
        Money.wons(11000),
        new PercentDiscountPolicy(0.1,
            new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
            new SequenceCondition(2),
            new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59))
        ));
    log.info("test : {}", titanic);
    log.info("tset : {}", titanic.getFee());
//    titanic.getFee();

  }
}
