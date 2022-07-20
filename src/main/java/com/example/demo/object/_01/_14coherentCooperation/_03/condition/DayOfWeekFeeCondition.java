package com.example.demo.object._01._14coherentCooperation._03.condition;

import com.example.demo.object._01._14coherentCooperation._03.Call;
import com.example.demo.object._01._14coherentCooperation._03.DateTimeInterval;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class DayOfWeekFeeCondition implements FeeCondition {
  private List<DayOfWeek> dayOfWeeks = new ArrayList<>();

  public DayOfWeekFeeCondition(DayOfWeek ...dayOfWeeks) {
    this.dayOfWeeks = Arrays.asList(dayOfWeeks);
  }

  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    return call.getInterval()
        .splitByDay()
        .stream()
        .filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
        .collect(toList());
  }
}
