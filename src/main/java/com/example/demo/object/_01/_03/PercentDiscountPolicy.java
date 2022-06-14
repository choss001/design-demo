package com.example.demo.object._01._03;

public class PercentDiscountPolicy extends DiscountPolicy{

  private double percent;

  public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
    super(conditions);
    this.percent = percent;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return null;
  }
}
