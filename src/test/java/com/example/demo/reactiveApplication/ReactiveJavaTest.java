package com.example.demo.reactiveApplication;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;


class ReactiveJavaTest {

  @Test
  void test () {
    getTemperatures("New York").subscribe(new TempSubscriber());
  }

  private Publisher<TempInfo> getTemperatures(String town) {
    return subscriber -> {
      TempProcessor processor = new TempProcessor();
      processor.subscribe(subscriber);
      processor.onSubscribe(new TempSubscription(processor, town));
    };
  }
}