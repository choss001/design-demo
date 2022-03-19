package com.example.demo.design_pattern.factory_method_pattern.versionOne;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManger {
  private List<ElevatorController> controllers;
  private SchedulingStrategyID strategyID;

  public ElevatorManger(int controllerCount, SchedulingStrategyID strategyID){
    controllers = new ArrayList<ElevatorController>(controllerCount);

    for (int i = 0; i < controllerCount; i++){
      ElevatorController controller = new ElevatorController(i + 1);
      controllers.add(controller);
    }
    this.strategyID = strategyID;
  }
  public void setStrategyID(SchedulingStrategyID strategyID){
    this.strategyID = strategyID;
  }

  void requestElevator(int destination, Direction direction){
    ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
    System.out.println(scheduler);
    int selectedElevator = scheduler.selectElevator(this, destination, direction);
    controllers.get(selectedElevator).gotoFloor(destination);
  }
}
