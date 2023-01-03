package com.example.demo.design.factory_method_pattern.versionTwo;

public class Client {
  public static void main(String[] args) {
    ElevatorManger emWithResponseTimeScheduler = new ElevatorManagerWithResponseTimeScheduling(5);
    emWithResponseTimeScheduler.requestElevator(5, Direction.UP);
  }
}
