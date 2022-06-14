package rxJava;

import com.example.demo.reactiveApplication.*;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

@Slf4j
class rxJavaTest {

  @Test
  void test () {
//    Observable<TempInfo> observable = getTemperature("New York");
//    Observable<TempInfo> observable = getCelsiusTemperature("New York");

    Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
    observable.subscribe(new rxJava.TempObserver());
    observable.blockingSubscribe(new rxJava.TempObserver());
  }

  public static Observable<TempInfo> getTemperature(String town) {
    return Observable.create(emitter ->
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe(i -> {
              if (!emitter.isDisposed()){
                if(i >= 5){
                  emitter.onComplete();
                }else{
                  try {
                    emitter.onNext(TempInfo.fetch(town));
                  }catch (Exception e){
                    emitter.onError(e);
                  }
                }
              }}));
  }

  private static Observable<TempInfo> getCelsiusTemperature(String town) {
    return getTemperature(town)
        .map(temp -> new TempInfo(temp.getTown(), (temp.getTemp() - 32 ) * 5 / 9));
  }

  private static Observable<TempInfo> getCelsiusTemperatures(String... towns) {
    return Observable.merge(Arrays.stream(towns)
        .map(rxJava.TempObservable::getCelsiusTemperature)
        .collect(toList()));
  }

  @Test
  void test2() {
    List<Integer> list = new ArrayList<>();
    Disposable subscribe = Observable.just(1, 2, 3, 4)
            .doOnNext(System.out::println)
            .subscribe(list::add);
    log.info("test : {}", list);

  }

  @Test
  void test3() {
    Observable.just(1,2,3,4)
            .map(value -> {
              Thread.sleep(1000);
                      return value;
            })
            .subscribeOn(Schedulers.single())
            .obs
  }


}