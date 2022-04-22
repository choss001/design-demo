package com.example.demo.future;

import java.util.Random;

public class DelayUtil {
  public static void delay(){
    try{
      Thread.sleep(1000L);
    }catch(InterruptedException e){
      throw new RuntimeException(e);
    }
  }

  private static final Random random = new Random();
  public static void randomDelay() {
    int delay = 500 + random.nextInt(2000);
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
