package com.example.demo.reactiveApplication.p01;

import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;

public class _L07_MethodChainSample {

  @Test
  void test () {
    Flowable<Integer> flowable =
        Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .filter(data -> data % 2 == 0)
            .map(data -> data * 100);

    flowable.subscribe(data -> System.out.println("data=" + data));
  }
}
