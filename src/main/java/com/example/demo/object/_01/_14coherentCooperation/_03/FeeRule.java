package com.example.demo.object._01._14coherentCooperation._03;

import com.example.demo.object._01._14coherentCooperation._03.condition.FeeCondition;

public class FeeRule {
  private FeeCondition feeCondition;
  private FeePerDuration feePerDuration;

  public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
    this.feeCondition = feeCondition;
    this.feePerDuration = feePerDuration;
  }

  public Money calculateFee(Call call) {
    return feeCondition.findTimeIntervals(call)
        .stream()
        .map(each -> feePerDuration.calculate(each))
        .reduce(Money.ZERO, (first, second) -> first.plus(second));
  }
}
