package com.example.demo.design.factory_method_pattern.practice_two.before;

public class CarStateFactory {
  public static CarState getState(CarStateID stateID, Car car){
    CarState state = null;
    switch(stateID){
      case NORMAL:
        state = NormalState.getInstance(car);
        break;
      case LIMP_MODE:
        state = LimpState.getInstance(car);
        break;
    }
    return state;
  }
}
