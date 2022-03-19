package com.example.demo.design_pattern_observer.three;

import com.example.demo.design_pattern_observer.two.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
  private List<com.example.demo.design_pattern_observer.two.Observer> observers = new ArrayList<com.example.demo.design_pattern_observer.two.Observer>();

  public void attach(com.example.demo.design_pattern_observer.two.Observer observer) {
    observers.add(observer);
  }

  public void detach(com.example.demo.design_pattern_observer.two.Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(){
    for(Observer o:observers)
      o.update();
  }
}
