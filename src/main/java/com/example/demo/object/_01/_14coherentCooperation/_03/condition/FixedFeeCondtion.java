package com.example.demo.object._01._14coherentCooperation._03.condition;

import com.example.demo.object._01._14coherentCooperation._03.Call;
import com.example.demo.object._01._14coherentCooperation._03.DateTimeInterval;

import java.util.Arrays;
import java.util.List;

public class FixedFeeCondtion implements FeeCondition{
  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    return Arrays.asList(call.getInterval());
  }
}
