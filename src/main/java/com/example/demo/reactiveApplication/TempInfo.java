package com.example.demo.reactiveApplication;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

//@Slf4j
public class TempInfo {

  public static final Random random = new Random();

  private final String town;
  private final int temp;

  public TempInfo(String town, int temp) {
    this.town = town;
    this.temp = temp;
  }

  public static TempInfo fetch(String town) {
    if(random.nextInt(10) == 0)
      throw new RuntimeException("Error!");
    return new TempInfo(town, random.nextInt(100));
  }

  @Override
  public String toString() {
//    log.info("{} : {}", town, temp);
    return town + " : " + temp;
  }

  public int getTemp() {
    return temp;
  }

  public String getTown() {
    return town;
  }
}


