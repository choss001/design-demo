package rxJava.buffer;

import io.reactivex.rxjava3.core.Flowable;
import rxJava.DebugSubscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BufferSample1 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<List<Long>> flowable =
                Flowable.interval(100L, TimeUnit.MILLISECONDS)
                        .take(10)
                        .buffer(4);
        flowable.subscribe(new DebugSubscriber<>());
        Thread.sleep(3000L);
    }
}
