package com.example.demo.reactiveApplication;

import org.junit.jupiter.api.Test;


class ReactiveJavaTest {

  @Test
  void test () {
    getTemperatures("New York").subscribe(new TempSubscriber());
  }

  private Publisher<TempInfo> getTemperatures(String town) {
    return subscriber -> subscriber.onSubscribe(
        new TempSubscription(subscriber, town)
      // 구독자의 구독중상태를 추가한다 (템프구독, 구독자정보, 지역) .
    );
  }
}