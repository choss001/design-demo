package com.example.demo.persistentDataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainJourneyTest {


  @Test
  void test() {
  }

  static TrainJourney link(TrainJourney a, TrainJourney b) {
    if (a==null) return b;
    TrainJourney t =a;
    while (t.onward != null) {
      t = t.onward;
    }
    t.onward =b;
    return a;
  }

  static TrainJourney append(TrainJourney a, TrainJourney b) {
    return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
  }
}