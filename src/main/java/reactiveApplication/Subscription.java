package reactiveApplication;

public interface Subscription {
  void request(long n);
  void cancel();
}
