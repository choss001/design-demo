package com.example.demo.design.design_pattern_observer.three;

import com.example.demo.design.design_pattern_observer.two.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
  private List<Observer> observers = new ArrayList<Observer>();

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void detach(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(){
    for(Observer o:observers)
      o.update();
  }
}
