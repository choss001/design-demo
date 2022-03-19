package com.example.demo.design_pattern.factory_method_pattern.practice_one;

public abstract class Motor {
  private MotorStatus motorStatus;

  public Motor() {
    motorStatus = MotorStatus.STOPPED;
  }

  private void setMotorStatus(MotorStatus motorStatus) {
    this.motorStatus = motorStatus;
  }

  public MotorStatus getMotorStatus() {
    return motorStatus;
  }

  public void move(Direction direction) {
    MotorStatus motorStatus = getMotorStatus();

    if (motorStatus == MotorStatus.MOVING) {
      return;
    }
    moveMotor(direction);
    setMotorStatus(MotorStatus.MOVING);
  }
  protected abstract void moveMotor(Direction direction);
  public void stop() {
    motorStatus = MotorStatus.STOPPED;
  }
}
