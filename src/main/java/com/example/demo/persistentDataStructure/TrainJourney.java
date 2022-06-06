package com.example.demo.persistentDataStructure;

public class TrainJourney {
  public int price;
  public TrainJourney onward;

  public TrainJourney(int p, TrainJourney t) {
    price = p;
    onward = t;
  }
}
