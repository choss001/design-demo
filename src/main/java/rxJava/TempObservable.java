package rxJava;

import com.example.demo.reactiveApplication.TempInfo;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.concurrent.TimeUnit;

public class TempObservable extends Observable<TempInfo> {
  @Override
  protected void subscribeActual(@NonNull Observer<? super TempInfo> observer) {

  }

  public static Observable<TempInfo> getCelsiusTemperature(String town) {
    return getTemperature(town)
        .map(temp -> new TempInfo(temp.getTown(), (temp.getTemp() - 32 ) * 5 / 9));
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
}
