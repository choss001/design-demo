package com.example.demo.design.one;

public class Client {
  public static void main(String[] args) {
    Display road = new RoadDisplay();
    road.draw();

    Display roadWithLane = new LaneDecorator(new RoadDisplay());
    roadWithLane.draw();

    Display roadWithTraffic = new TrafficeDecorator(new RoadDisplay());
    roadWithTraffic.draw();

    Display roadWithLaneAndTraffic = new TrafficeDecorator(new LaneDecorator(new RoadDisplay()));
    System.out.println(roadWithLaneAndTraffic);
    roadWithLaneAndTraffic.draw();
  }
}
