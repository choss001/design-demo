package rxJava;

import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class DebugSubscriber <T> extends DisposableSubscriber<T> {
    private String label;
    public DebugSubscriber() {
        super();
    }

    public DebugSubscriber(String label) {
        super();
        this.label = label;
    }


    @Override
    public void onNext(T data) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": " + data);
        }else {
            System.out.println(threadName + ": " + label + ": " + data);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": ERORR! = " + throwable);
        }else {
            System.out.println(threadName + ": " + label + ": ERORR! = " + throwable);
        }

    }

    @Override
    public void onComplete() {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": COMPLETE!");
        }else {
            System.out.println(threadName + ": " + label + ": COMPLETE!");
        }

    }
}

