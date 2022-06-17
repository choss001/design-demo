package com.example.demo.object._01._07;

import java.time.Duration;
import java.util.List;

public class Movie {
  private String title;
  private Duration runningTime;
  private Money fee;
  private List<DiscountCondition> discountConditions;

  private MovieType movieType;
  private Money discountAmount;
  private double discountPercent;
  public Money calculateMovieFee(Screening screening) {
    if (isDiscountable(screening))
      return fee.minus(calculateDiscountAmount());

    return fee;
  }

  private boolean isDiscountable(Screening screening) {
    return discountConditions.stream()
        .anyMatch(condition -> condition.isSatisfiedBy(screening));
  }

  private Money calculateDiscountAmount() {
    switch(movieType){
      case AMOUNT_DISCOUNT -> calculateAmountDiscountAmount();
      case PERCENT_DISCOUNT -> calculatePercentDiscountAmount();
      case NONE_DISCOUNT -> calculateNoneDiscountAmount();
    }
    throw new IllegalStateException();
  }
  private Money calculateAmountDiscountAmount(){
    return discountAmount;
  }

  private Money calculatePercentDiscountAmount() {
    return fee.times(discountPercent);
  }

  private Money calculateNoneDiscountAmount() {
    return Money.ZERO;
  }
}
