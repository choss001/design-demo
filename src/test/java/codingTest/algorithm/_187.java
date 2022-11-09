package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class _187 {

  @Test
  void test1(){

  }

  private List<Integer> karatsuba(List<Integer> a, List<Integer> b) {
    return null;
  }

  @Test
  void test2() {
    String a = "FFFMMM";
    String b = "MMMFFF";
    for(int i = 0; i < a.length(); i ++){

    }

  }
  @Test
  void test3() {
    bino(8, 4);
  }

  private int bino(int n, int r) {
    log.info("call bino  n : {}, r : {}", n, r);
    if(r == 0 || n == r) return 1;
    return bino(n - 1, r - 1) + bino(n - 1, r);
  }
}
