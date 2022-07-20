package com.example.demo.object._01.supplementA.condition;

import com.example.demo.object._01.supplementA.Call;
import com.example.demo.object._01.supplementA.DateTimeInterval;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

public class DurationFeeCondition implements FeeCondition {
  private Duration from;
  private Duration to;

  public DurationFeeCondition(Duration from, Duration to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    if(call.getInterval().duration().compareTo(from) < 0){
      return emptyList();
    }
    return Arrays.asList(DateTimeInterval.of(
        call.getInterval().getFrom().plus(from),
        call.getInterval().duration().compareTo(to) > 0 ?
            call.getInterval().getFrom().plus(to) :
            call.getInterval().getTo()));
  }
}
