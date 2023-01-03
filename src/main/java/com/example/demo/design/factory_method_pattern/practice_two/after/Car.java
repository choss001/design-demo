package com.example.demo.design.factory_method_pattern.practice_two.after;


public class Car {
  private int speed;
  private CarState normalState;
  private CarState limpState;
  private CarState curState;

  public Car() {
    normalState = new NormalState(this);
    limpState = new LimpState(this);
    curState = normalState;
  }

  public CarState getLimpMode(){
    return limpState;
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
    return normalState;
  }

}
