package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CircularPrimeNumberTest {
  private char cout;

  @Test
  void test1() {
//    printDecimal(3,8);
    log.info("result : {} ",recursiveSum(10));
  }

  private void printDecimal(int a, int b) {
    int iter =0;
    while(a > 0){
      if(iter++ == 1) System.out.printf(".");
      System.out.printf("%d", a / b);
      a = (a % b) * 10;
    }

  }
  private int recursiveSum(int n){
    if(n == 1) return 1;
    return n + recursiveSum(n-1);
  }

  @Test
  void test2(){
    int n = 7;
  }
  private void recusiveGetInput(int n, int index, ){
    if(index == 3){
      System.out.printf("");
      return;
    }
  }
}
