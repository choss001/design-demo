package com.example.demo.future;

public class DelayUtil {
  public static void delay(){
    try{
      Thread.sleep(1000L);
    }catch(InterruptedException e){
      throw new RuntimeException(e);
    }
  }
}
