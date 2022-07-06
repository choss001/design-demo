package com.example.demo.object._01._07;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
  private DiscountConditionType type;
  private int sequence;
  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  public boolean isSatisfiedBy(Screening screening) {
    if (type == DiscountConditionType.PERIOD) {
      return isSatisfiedByPeriod(screening);
    }

    return isSatisfiedBySequence(screening);
  }

  private boolean isSatisfiedByPeriod(Screening screening) {
    System.out.println("push test");
    return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
        startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
        endTime.isAfter(screening.getWhenScreened().toLocalTime()) == true;

  }

  private boolean isSatisfiedBySequence(Screening screening){
    return sequence == screening.getSequence();
  }
}
