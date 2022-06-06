package com.example.demo.reactiveApplication;

public interface Subscription {
  void request(long n);
  void cancel();
}
