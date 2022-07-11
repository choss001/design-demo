package com.example.demo.object._01._14coherentCooperation._03;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone(
                new FixedFeePolicy(Money.wons(10),
                        Duration.ofSeconds(10)));

        Phone phone1 = new Phone(new NightDiscountPolicy(Money.wons(5)
                , Money.wons(10), Duration.ofSeconds(10)));

        Phone phone2 = new Phone(new RateDiscountablePolicy(Money.wons(1000),
                new TaxablePolicy(0.05,
                        new FixedFeePolicy(Money.wons(10),
                                Duration.ofSeconds(10)))));

        Phone phone3 = new Phone(new RateDiscountablePolicy(Money.wons(1000),
                new TaxablePolicy(0.05,
                        new NightDiscountPolicy(Money.wons(5),
                                Money.wons(10),
                                Duration.ofSeconds(10)
                                ))));

        log.info("test : {}", phone1);


        log.info("test : {}", phone.calculateFee());
        log.info("test : {}", phone.getCalls());
        log.info("test : {}", Duration.ofHours(1));
        log.info("hour : {}", Duration.ofHours(1).toHours());

    }
}
