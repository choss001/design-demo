package rxjava.counterSample;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CounterSample {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> counter.increment(),
                        error -> System.out.println("에러=" + error),
                        () -> {
                            System.out.println(
                                    "test 1 \n"+
                                    "counter.get()=" + counter.get() +
                                    "\ncurrent Thread : " +
                                    Thread.currentThread().getName());
                        }

                );

        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> counter.increment(),
                        error -> System.out.println("에러=" + error),
                        () -> {
                            System.out.println();
                            System.out.println(
                                    "test 2 \n"+
                                    "counter.get()=" + counter.get() +
                                    "\ncurrent Thread : " +
                                    Thread.currentThread().getName());
                        }

                );
        System.out.println("current Thread : " +
                Thread.currentThread().getName());
        Thread.sleep(1000L);
    }
}
