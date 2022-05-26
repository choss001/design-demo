package rxJava;

import com.example.demo.reactiveApplication.*;
import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

class rxJavaTest {

  @Test
  void test () {
//    Observable<TempInfo> observable = getTemperature("New York");
//    Observable<TempInfo> observable = getCelsiusTemperature("New York");

    Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
    observable.subscribe(new TempObserver());
    observable.blockingSubscribe(new TempObserver());
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
        .map(TempObservable::getCelsiusTemperature)
        .collect(toList()));
  }

}