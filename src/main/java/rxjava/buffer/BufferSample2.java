//package rxJava.buffer;
//
//import io.reactivex.rxjava3.core.Flowable;
//import lombok.extern.slf4j.Slf4j;
//import rxJava.DebugSubscriber;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//public class BufferSample2 {
//    public static void main(String[] args) throws InterruptedException {
//        Flowable<List<Long>> flowable =
//                Flowable.interval(300L, TimeUnit.MILLISECONDS)
//                        .take(7)
//                        .buffer( data ->
//                                    Flowable.timer(1000L, TimeUnit.MILLISECONDS)
//                                            .subscribe(data) );
//        flowable.subscribe(new DebugSubscriber<>());
//        Thread.sleep(3000L);
//    }
//}
