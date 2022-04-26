package reactiveApplication;

public interface Subscriber<T> {
  void onError(Throwable t);

  void onSubscribe(Subscription subscription);

  void onNext(T t);

  void onComplete();
}
