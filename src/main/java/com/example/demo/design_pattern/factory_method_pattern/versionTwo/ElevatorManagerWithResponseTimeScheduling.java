package com.example.demo.design_pattern.factory_method_pattern.versionTwo;

public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManger{

  public ElevatorManagerWithResponseTimeScheduling(int contollerCount) {
    super(contollerCount);

  }
  @Override
  protected ElevatorScheduler getScheduler() {
    ElevatorScheduler scheduler = ResponseTimeScheduler.getScheduler();
    return scheduler;
  }
}
