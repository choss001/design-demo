package com.example.demo.reactiveApplication;

public interface Processor <T, R> extends Subscriber<T>, Publisher<R>{
}
