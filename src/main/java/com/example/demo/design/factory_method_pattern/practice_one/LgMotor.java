package com.example.demo.design.factory_method_pattern.practice_one;

public class LgMotor extends Motor{
  @Override
  protected void moveMotor(Direction direction) {
    System.out.println("move Lg Motor " + direction);
  }
}
