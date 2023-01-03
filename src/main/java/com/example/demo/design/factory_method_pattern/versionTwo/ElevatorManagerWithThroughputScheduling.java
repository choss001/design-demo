package com.example.demo.design.factory_method_pattern.versionTwo;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManger{
  public ElevatorManagerWithThroughputScheduling(int controllerCount) {
    super(controllerCount);
  }
  @Override
  protected ElevatorScheduler getScheduler() {
    ElevatorScheduler scheduler = ThroughputScheduler.getInstance();
    return scheduler;
  }
}
