package codingTest.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _184 {

  @Test
  void test1() {

  }

  int[] multiply(int[] a, int[] b) {
    int[] c = new int[a.length + b.length + 1];
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < b.length; j++)
        c[i + j] += a[i] * b[j];


    return c;
  }

  private void normalize(List<Integer> num) {
    num.add(0);
    for (int i = 0; i < num.size(); i++) {
      if(num.get(i) < 0){
        int borrow = (Math.abs(num.get(i)) + 9) / 10;
        num.set(i+1, num.get(i+1) - borrow);
        num.set(i, num.get(i) + borrow * 10);
      }else{
        num.set(i + 1, num.get(i + 1) + num.get(i) / 10);
        num.set(i, num.get(i) % 10);
      }
    }
    while(num.length > 1 && num[num.length -1] == 0)

  }
}
