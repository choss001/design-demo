package com.example.demo.object._01.supplementA.condition;

import com.example.demo.object._01.supplementA.Call;
import com.example.demo.object._01.supplementA.DateTimeInterval;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TimeOfDayFeeCondition implements FeeCondition {
  private LocalTime from;
  private LocalTime to;

  public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    return call.getInterval().splitByDay()
        .stream()
        .map(each ->
            DateTimeInterval.of(
                LocalDateTime.of(each.getFrom().toLocalDate(), from(each)),
                LocalDateTime.of(each.getTo().toLocalDate(), to(each))))
        .collect(toList());
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
