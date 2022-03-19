package com.example.demo.design_pattern.factory_method_pattern.practice_two.after;

public abstract class CarState {
  protected Car car;

  protected CarState(Car car) {
    this.car = car;
  }

  public void speedDown(int targetSpeed) {
    System.out.println("Speed: " + car.getSpeed());
    if(targetSpeed < car.getSpeed())
      car.setSpeed(targetSpeed);

    System.out.println(" ==> " + car.getSpeed());
  }

  public abstract void speedUp(int targetSpeed);
  public abstract void engineFailedDetected();
  public abstract void engineRepaired();
}
