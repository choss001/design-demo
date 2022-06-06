package rxjava.observerOn;

import io.reactivex.rxjava3.core.Flowable;

import java.util.concurrent.TimeUnit;

public class FlatMapSample01 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable =
                Flowable.just("A", "B", "C")
                        .flatMap(data -> {
                            return Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS);
                        });
        flowable.subscribe(data -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + data);
        });

        Thread.sleep(2000L);
    }
}
