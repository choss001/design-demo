package com.example.demo.object._01._04perfect;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
  private Money discountAmount;

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    this.discountAmount = discountAmount;
  }
  @Override
  protected Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }
}
