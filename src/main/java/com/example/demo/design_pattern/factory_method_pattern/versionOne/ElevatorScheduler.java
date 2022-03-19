package com.example.demo.design_pattern.factory_method_pattern.versionOne;

public interface ElevatorScheduler {
  int selectElevator(ElevatorManger manger, int destination, Direction direction);
}
