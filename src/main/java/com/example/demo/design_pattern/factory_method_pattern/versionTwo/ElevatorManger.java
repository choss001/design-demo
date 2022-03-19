package com.example.demo.design_pattern.factory_method_pattern.versionTwo;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorManger {
  private List<ElevatorController> controllers;

  public ElevatorManger(int controllerCount){
    controllers = new ArrayList<ElevatorController>(controllerCount);
    for (int i = 0; i < controllerCount; i++){
      ElevatorController controller = new ElevatorController(i + 1);
      controllers.add(controller);
    }
  }
  protected abstract ElevatorScheduler getScheduler();

  void requestElevator(int destination, Direction direction){
    ElevatorScheduler scheduler = getScheduler();
    System.out.println(scheduler);
    int selectedElevator = scheduler.selectElevator(this, destination, direction);
    controllers.get(selectedElevator).gotoFloor(destination);
  }
}
