package com.example.demo.design_pattern.factory_method_pattern.versionTwo;

public class ResponseTimeScheduler implements ElevatorScheduler {

  private static ElevatorScheduler scheduler;
  private ResponseTimeScheduler() {}
  public static ElevatorScheduler getScheduler() {
    if (scheduler == null)
      scheduler = new ResponseTimeScheduler();
    return scheduler;
  }
  public int selectElevator(ElevatorManger manger, int destination, Direction direction) {
    return 1;
  }
}
