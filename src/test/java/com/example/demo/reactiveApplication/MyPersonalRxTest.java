package com.example.demo.reactiveApplication;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;


public class MyPersonalRxTest {

  private Random random = new Random();

  @Test
  void test() throws InterruptedException {
//    Observable.just(100, 200, 300, 400, 500)
//        .doOnNext(data -> {
//          System.out.println(currentThread() + "doOnNext : " + data);
//             sleep(random.nextInt(5000));
//        })
//        .filter(number -> number > 300)
//        .subscribe(num -> System.out.println(currentThread() + "result : " + num));


    Disposable subscribe1 = Observable.just(100, 200, 300, 400, 500)
        .doOnNext(data -> {
          System.out.println(currentThread() + "doOnNext : " + data);
          sleep(random.nextInt(5000));
        })
        .subscribeOn(Schedulers.io())
        .filter(number -> number > 300)
        .subscribe(num -> System.out.println(currentThread() + "result : " + num));

    Disposable subscribe2 = Observable.just(100, 200, 300, 400, 500)
        .doOnNext(data -> {
          System.out.println(currentThread() + "doOnNext : " + data);
          sleep(random.nextInt(5000));
        })
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation())
        .filter(number -> number > 300)
        .subscribe(num -> System.out.println(currentThread() + "result : " + num));
    sleep(10000);
  }

//  @Test
//  void baeldung1() {
//    Observable<String> observable = Observable.just("Hello");
//    observable.subscribe(s -> result = s);
//  }
}
