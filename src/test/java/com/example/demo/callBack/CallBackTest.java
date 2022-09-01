package com.example.demo.callBack;


import org.junit.jupiter.api.Test;

public class CallBackTest {

    @Test
    void test() {
        CallBackTest callBackTest = new CallBackTest();
        Solider rambo = callBackTest.new Solider();

        rambo.runContext(new Strategy() {
            @Override
            public void runStrategy() {
                try {
                    Thread.sleep(3000);
                    System.out.println("템플릿 콜백버젼: 탕! 타탕!! 탕탕탕!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

    class Solider {
        void runContext(Strategy strategy) {
            System.out.println("배틀 그라운드 시작");
            strategy.runStrategy();
            System.out.println("배틀 종료");
        }
    }

    @Test
    void test2() {
        new CallBackTestTwo().doWork(new CallbackTwo() { // implementing class
            @Override
            public void call() {
                System.out.println("callback called");
            }
        });
    }

    public class CallBackTestTwo {

        public void doWork(CallbackTwo callback) {
            System.out.println("doing work");
            callback.call();
        }

    }

    public interface CallbackTwo {
        void call();
    }
}
