package com.example.demo.reactiveApplication;

public interface Publisher<T> {

  void subscribe(Subscriber<? super T> s);
}
