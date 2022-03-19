package com.example.demo.design_pattern.factory_method_pattern.versionOne;

import java.util.Calendar;

public class SchedulerFactory {

  public static ElevatorScheduler getScheduler(SchedulingStrategyID strategyID) {
    ElevatorScheduler scheduler = null;
    switch (strategyID) {
      case RESPONSE_TIME:
        scheduler = ResponseTimeScheduler.getScheduler();
        break;
      case THROUGHPUT:
        scheduler = ThroughputScheduler.getInstance();
        break;
      case DYNAMIC:
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour < 12)
          scheduler = ResponseTimeScheduler.getScheduler();
        else
          scheduler = ThroughputScheduler.getInstance();
        break;
    }
    return scheduler;
  }
}
