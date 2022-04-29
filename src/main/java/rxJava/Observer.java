package rxJava;

import io.reactivex.rxjava3.disposables.Disposable;

public interface Observer <T>{
  void onSubscribe(Disposable disposable);

  void onNext(T t);

  void onError(Throwable throwable);

  void onComplete();
}
