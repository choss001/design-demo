package com.example.demo.design.factory_method_pattern.practice_two.before;


public class Car {
  private int speed;
  private CarState curState;

  public Car() {
    curState = CarStateFactory.getState(CarStateID.NORMAL,this);
  }

  public CarState getLimpMode(){
    return CarStateFactory.getState(CarStateID.LIMP_MODE, this);
  }

  public void setState(CarState state){
    curState = state;
  }

  public void speedDown(int targetSpeed) {
    curState.speedDown(targetSpeed);
  }

  public void engineFailedDetected(){
    curState.engineFailedDetected();
  }
  public void engineRepaired(){
    curState.engineRepaired();
  }

  public void speedUp(int targetSpeed) {
    curState.speedUp(targetSpeed);
  }

  public int getSpeed(){
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public CarState getNormalMode() {
    return CarStateFactory.getState(CarStateID.NORMAL, this);
  }

}
