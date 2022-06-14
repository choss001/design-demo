package com.example.demo.object._01._04;

import com.example.demo.object._01._03.DiscountCondition;
import com.example.demo.object._01._03.Money;

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

  public MovieType getMovieType() {
    return movieType;
  }

//  public void
}
