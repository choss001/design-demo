package com.example.demo.object._01._14coherentCooperation._03;

import java.time.LocalTime;
import java.util.List;

public class TimeOfDayFeeCondition implements FeeCondition{
  private LocalTime from;
  private LocalTime to;

  public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    return null;
  }

  private LocalTime from(DateTimeInterval interval) {
    return interval.getFrom().toLocalTime().isBefore(from) ?
        from : interval.getFrom().toLocalTime();
  }

  private LocalTime to(DateTimeInterval interval) {
    return interval.getTo().toLocalTime().isAfter(to) ?
        to : interval.getTo().toLocalTime();
  }
}
