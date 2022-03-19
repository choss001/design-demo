package com.example.demo.design_pattern.factory_method_pattern.versionOne;

public class ThroughputScheduler implements ElevatorScheduler {
  private static ElevatorScheduler scheduler;

  private ThroughputScheduler() {
  }

  public static ElevatorScheduler getInstance() {
    if (scheduler == null)
      scheduler = new ThroughputScheduler();
    return scheduler;
  }

  public int selectElevator(ElevatorManger manger, int destination, Direction direction) {
    return 0;
  }
}
