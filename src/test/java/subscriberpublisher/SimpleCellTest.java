package subscriberpublisher;

import org.junit.jupiter.api.Test;

class SimpleCellTest {

  @Test
  void test() {
    SimpleCell c3 = new SimpleCell("C3");
    SimpleCell c2 = new SimpleCell("C2");
    SimpleCell c1 = new SimpleCell("C1");

    c1.subscribe(c3);
    c1.onNext(10);
    c2.onNext(20);
  }

  @Test
  void test2() {
    ArithmeticCell c3 = new ArithmeticCell("C3");

    SimpleCell c2 = new SimpleCell("C2");
    SimpleCell c1 = new SimpleCell("C1");

    c1.subscribe(left -> c3.setLeft(left));
    c2.subscribe(right -> c3.setRight(right));

    c1.onNext(10);
    c2.onNext(20);
    c1.onNext(15);
  }

  @Test
  void test3() {
    ArithmeticCell c5 = new ArithmeticCell("C5");
    ArithmeticCell c3 = new ArithmeticCell("C3");

    SimpleCell c4 = new SimpleCell("C4");
    SimpleCell c2 = new SimpleCell("C2");
    SimpleCell c1 = new SimpleCell("C1");

    c1.subscribe(c3::setLeft);
    c2.subscribe(c3::setRight);

    c3.subscribe(c5::setLeft);
    c4.subscribe(c5::setRight);

    c1.onNext(10);
    c2.onNext(20);
    c1.onNext(15);
    c4.onNext(1);
    c4.onNext(3);
  }

}