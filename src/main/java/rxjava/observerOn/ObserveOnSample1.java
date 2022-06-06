package rxjava.observerOn;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ObserveOnSample1 {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable =
                Flowable.interval(300L, TimeUnit.MILLISECONDS)
                        .onBackpressureDrop();

        flowable
                .observeOn(Schedulers.computation(), false, 2)
                .subscribe(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long item) {
                        try{
                            Thread.sleep(1000L);
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        String threadName = Thread.currentThread().getName();
                        System.out.println("currentTime : "+System.currentTimeMillis());
                        System.out.println(threadName + ": " + item);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("끝났습니다.");
                    }
                });
        Thread.sleep(7000L);
    }
}
