package rxJava.repeat;

import io.reactivex.rxjava3.core.Flowable;
import lombok.extern.slf4j.Slf4j;
import rxJava.DebugSubscriber;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RepeatWhenSample1 {
    public static void main(String[] args) throws InterruptedException {

        log.info("start : {}", System.currentTimeMillis());
        Flowable<String> flowable =
                Flowable.just(1,2,3)
                        .repeatWhen(completeHandler -> completeHandler
                                .delay(1000L, TimeUnit.MILLISECONDS)
                                .take(9)
                                .doOnNext(data -> System.out.println("emit: " + data))
                                .doOnComplete(() -> System.out.println("complete")))
        .map(data -> System.currentTimeMillis() + "ms: " + data);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(5000L);
    }
}
