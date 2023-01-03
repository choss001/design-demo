package com.example.demo.design.factory_method_pattern.practice_two.before;

public class LimpState extends CarState{
  public static final int LIMP_MODE_MAX_SPEED = 60;
  private static CarState state;

  private LimpState(Car car) {
    super(car);
  }

  public static CarState getInstance(Car car) {
    if(state == null)
      state = new LimpState(car);
    return state;
  }
  @Override
  public void speedUp(int targetSpeed) {
    System.out.println("Speed: " + car.getSpeed());
    if(targetSpeed > car.getSpeed() && targetSpeed < LIMP_MODE_MAX_SPEED)
      car.setSpeed(targetSpeed);

    System.out.println(" ==> " + car.getSpeed());

  }

  @Override
  public void engineFailedDetected() {

  }

  @Override
  public void engineRepaired() {
    car.setState(car.getNormalMode());
  }
}
