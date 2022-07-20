package com.example.demo.object._01.supplementA.condition;

import com.example.demo.object._01.supplementA.Call;
import com.example.demo.object._01.supplementA.DateTimeInterval;

import java.util.Arrays;
import java.util.List;

public class FixedFeeCondtion implements FeeCondition {
  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    return Arrays.asList(call.getInterval());
  }
}
