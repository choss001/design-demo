package rxjava.counterWithMergeSample;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxjava.counterSample.Counter;

public class CounterWithMergeSample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start :" +System.currentTimeMillis());
        final Counter counter = new Counter();

        Flowable<Integer> source1 = Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        Flowable<Integer> source2 = Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        Flowable.merge(source1, source2)
                .subscribe(
                        data -> counter.increment(),
                        error -> System.out.println("에러=" + error),
                        () -> {
                            System.out.println(
                                        "test 1 \n"+
                                        "counter.get()=" + counter.get() +
                                        "\ncurrent Thread : " +
                                        Thread.currentThread().getName() +
                                                "\ncurrent time :" + System.currentTimeMillis()

                                    );
                        }
                );

        System.out.println("end :" +System.currentTimeMillis());
        Thread.sleep(1000L);
    }
}
