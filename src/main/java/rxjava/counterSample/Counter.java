package rxjava.counterSample;

public class Counter {
    private volatile int count;

    public void increment() {
        count++;
    }

    public int get() {
        return count;
    }
}

