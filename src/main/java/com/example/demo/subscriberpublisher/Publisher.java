package com.example.demo.subscriberpublisher;

public interface Publisher<T> {
  void subscribe(Subscriber<? super T> subscriber);
}
