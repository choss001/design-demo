package com.example.demo.design.factory_method_pattern.practice_two.after;

public class NormalState extends CarState {
  protected NormalState(Car car) {
    super(car);
  }

  public void speedUp(int targetSpeed) {
    System.out.println("Speed: " + car.getSpeed());
    if(targetSpeed > car.getSpeed())
      car.setSpeed(targetSpeed);
    System.out.println(" ==> " + car.getSpeed());
  }
  @Override
  public void engineFailedDetected() {
    System.out.println("Speed");
    car.setSpeed(LimpState.LIMP_MODE_MAX_SPEED);
    System.out.println(" ==> " + car.getSpeed());
    car.setState(car.getLimpMode());
  }

  @Override
  public void engineRepaired() {
    System.out.println("Unexpected Event");
  }

}
