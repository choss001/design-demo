package com.example.demo.object._01.supplementA.condition;

import com.example.demo.object._01.supplementA.Call;
import com.example.demo.object._01.supplementA.DateTimeInterval;

import java.util.List;

public interface FeeCondition {
  List<DateTimeInterval> findTimeIntervals(Call call);
}
