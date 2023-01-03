package com.example.demo.design.factory_method_pattern.versionOne;

public class Client {
  public static void main(String[] args) {
    ElevatorManger emWithResponseTimeScheduler =
        new ElevatorManger(2, SchedulingStrategyID.RESPONSE_TIME);
    emWithResponseTimeScheduler.requestElevator(10, Direction.UP);

    ElevatorManger emWithThroughputScheduler =
        new ElevatorManger(2, SchedulingStrategyID.THROUGHPUT);
    emWithThroughputScheduler.requestElevator(10, Direction.UP);
  }
}
