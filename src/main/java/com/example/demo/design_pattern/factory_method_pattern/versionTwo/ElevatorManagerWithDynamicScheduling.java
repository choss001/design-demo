package com.example.demo.design_pattern.factory_method_pattern.versionTwo;

import java.util.Calendar;

public class ElevatorManagerWithDynamicScheduling extends ElevatorManger{

  public ElevatorManagerWithDynamicScheduling(int controllercount) {
    super(controllercount);
  }
  @Override
  protected ElevatorScheduler getScheduler() {
    ElevatorScheduler scheduler = null;
    int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    if (hour < 12) {
      scheduler = ResponseTimeScheduler.getScheduler();
    }else{
      scheduler = ThroughputScheduler.getInstance();
    }
    return scheduler;
  }
}
