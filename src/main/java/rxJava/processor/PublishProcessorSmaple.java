//package rxJava.processor;
//
//import io.reactivex.rxjava3.processors.PublishProcessor;
//import rxJava.DebugSubscriber;
//
//public class PublishProcessorSmaple {
//    public static void main(String[] args) {
//        PublishProcessor<Integer> processor = PublishProcessor.create();
//
//        processor.subscribe(new DebugSubscriber<>("No.1"));
//
//        processor.onNext(1);
//        processor.onNext(2);
//        processor.onNext(3);
//
//        System.out.println("Subscriber No.2 추가");
//        processor.subscribe(new DebugSubscriber<>("--- No.2"));
//
//        processor.onNext(4);
//        processor.onNext(5);
//
//        processor.onComplete();
//
//        System.out.println("Subscriber No.3 추가");
//        processor.subscribe(new DebugSubscriber<>("------ No.3"));
//
//    }
//}
