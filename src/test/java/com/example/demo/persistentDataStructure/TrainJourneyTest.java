package com.example.demo.persistentDataStructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TrainJourneyTest {


  @Test
  void test() {

    TrainJourney e = new TrainJourney(13_550, null);
    TrainJourney d = new TrainJourney(13_550, e);
    TrainJourney c = new TrainJourney(14_000, null);
    TrainJourney b = new TrainJourney(15_500, c);
    TrainJourney a = new TrainJourney(13_000, b);
    TrainJourney link = link(a, d);
    System.out.println("end");
  }

  @Test
  void appendTest() {

    TrainJourney e = new TrainJourney(13_550, null);
    TrainJourney d = new TrainJourney(13_550, e);
    TrainJourney c = new TrainJourney(14_000, null);
    TrainJourney b = new TrainJourney(15_500, c);
    TrainJourney a = new TrainJourney(13_000, b);
    TrainJourney link = append(a, d);
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