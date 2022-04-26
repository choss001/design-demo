package reactiveApplication;

import org.junit.jupiter.api.Test;
import subscriberpublisher.Publisher;

class ReactiveJavaTest {

  @Test
  void test () {
    getTemperatures("New York").subscribe(new TempSubscriber());
  }

  private static Publisher<TempInfo> getTemperatures(String town) {
    return subscriber -> subscriber.onSubscribe(
        new TempSubscription((Subscriber<? super TempInfo>) subscriber, town)
    );
  }
}