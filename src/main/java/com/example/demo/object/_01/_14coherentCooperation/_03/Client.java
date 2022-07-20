package com.example.demo.object._01._14coherentCooperation._03;

import com.example.demo.object._01._14coherentCooperation._03.condition.DayOfWeekFeeCondition;
import com.example.demo.object._01._14coherentCooperation._03.condition.TimeOfDayFeeCondition;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalTime;

@Slf4j
public class Client {
  public static void main(String[] args) {
    Phone phone4 =
        new Phone(
            new RateDiscountablePolicy(
                Money.wons(1000L),
                new BasicRatePolicy(
                    new FeeRule(
                        new TimeOfDayFeeCondition(
                            LocalTime.of(3, 30),
                            LocalTime.of(13, 30)),
                        new FeePerDuration(
                            Money.wons(1000),
                            Duration.ofHours(6))))));
    phone4.calculateFee();
    log.info("phone4 : {}", phone4.getCalls());
    log.info("test");

  }
}
