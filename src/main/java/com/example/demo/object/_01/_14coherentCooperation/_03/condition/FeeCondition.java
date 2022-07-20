package com.example.demo.object._01._14coherentCooperation._03.condition;

import com.example.demo.object._01._14coherentCooperation._03.Call;
import com.example.demo.object._01._14coherentCooperation._03.DateTimeInterval;

import java.util.List;

public interface FeeCondition {
  List<DateTimeInterval> findTimeIntervals(Call call);
}
