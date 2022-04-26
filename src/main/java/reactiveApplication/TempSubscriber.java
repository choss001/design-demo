package reactiveApplication;

public class TempSubscriber implements Subscriber<TempInfo>{

  private Subscription subscription;


  @Override
  public void onError(Throwable t) {
    System.out.println(t.getMessage());
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(TempInfo tempInfo) {
    System.out.println(tempInfo);
    subscription.request(1 );
  }

  @Override
  public void onComplete() {
    System.out.println("Done!");
  }
}
