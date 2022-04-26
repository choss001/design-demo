package com.example.demo.subscriberpublisher;

import com.example.demo.reactiveApplication.Subscription;

public interface Subscriber <T>{

  void onNext(T t);
}
