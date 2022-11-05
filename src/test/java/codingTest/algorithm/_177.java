package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _177 {
  @Test
  void test1(){
    int i = fastSum(5);
    log.info("result : {}", i);
  }
  int fastSum(int n){
    if(n ==1 ) return 1;
    if(n % 2 == 1) return fastSum(n-1) + n;
    return 2*fastSum(n/2) + (n/2) * (n/2);
  }
}
/**
 * (1 + 2 + +n/2) + (
 *
 * 1~ 8
 * 1 2 3 4 5 6 7 8;
 * 1 2 3 8/2 8/2+1 6 7 8;
 *
 * fastSum(4) = 2 * fastSum(2) + 2 * 2 = 10;
 * fastSum(2) = 2 * fastSum(1) + 1 * 1 = 3;
 * fastSum(1) = 1;
 *
 * fastSum(5) = fastSum(4) + 5;
 * fastSum(4) = 2 * fastSum(2) + 2 * 2 = 10
 * fastSum(2) = 2 * fastSum(1) + 1 * 1 = 3;
 * fastSum(101) 3번
 * fastSUM(100) 2번
 * fastSum(1010 = 10) = fastSum(5)  4번;
 *
 *
 */
