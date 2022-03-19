package com.example.demo.design_pattern.factory_method_pattern.versionTwo;

public interface ElevatorScheduler {
  int selectElevator(ElevatorManger manger, int destination, Direction direction);
}
