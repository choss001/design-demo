package subscriberpublisher;

import reactiveApplication.Subscription;

public interface Subscriber <T>{
  void onSubscribe(Subscription subscription);
  void onNext(T t);
}
