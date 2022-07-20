package com.example.demo.object._01._14coherentCooperation._03;

import java.time.Duration;

public class FeePerDuration {
  private Money fee;
  private Duration duration;

  public FeePerDuration(Money fee, Duration duration) {
    this.fee = fee;
    this.duration = duration;
  }

  public Money calculate(DateTimeInterval interval) {
    return fee.times(interval.duration().getSeconds() / duration.getSeconds());
  }
}
