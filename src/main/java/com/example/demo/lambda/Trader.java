package com.example.demo.lambda;

public class Trader {
  private final String name;
  private final String city;

  public Trader(String n, String c) {
    this.name = n;
    this.city = c;
  }

  public String getName() {
    return this.name;
  }

  public String getCity() {
    return this.name;
  }

  public String toString() {
    return "Trader:" + this.name + " in " + this.city;
  }
}
