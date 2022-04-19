package com.example.demo.callBack;


import org.aspectj.weaver.ast.Call;
import org.junit.jupiter.api.Test;

public class CallBackTest {

  @Test
  void test() {
    CallBackTest callBackTest = new CallBackTest();
    CallBackTest.Solider rambo = callBackTest.new Solider();

    rambo.runContext(new Strategy() {
      @Override
      public void runStrategy() {
        System.out.println("템플릿 콜백버젼: 탕! 타탕!! 탕탕탕!");
      }
    });

    System.out.println("\n");
    rambo.runContext(new Strategy() {
      @Override
      public void runStrategy() {
        System.out.println("템플릿 콜백버젼: 수류탄 투척~! 쾅!!!");
      }
    });

  }
  class Solider{
    void runContext(Strategy strategy){
      System.out.println("배틀 그라운드 시작");
      strategy.runStrategy();
      System.out.println("배틀 종료");
    }
  }
}
