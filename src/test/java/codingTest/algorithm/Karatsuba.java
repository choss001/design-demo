package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@Slf4j
public class Karatsuba {

  private List<Integer> a = new ArrayList<>(Arrays.asList(5, 1));
  private List<Integer> b = new ArrayList<>(Arrays.asList(1, 6, 3));
  // 51 * 163 = 8313;
  private int n = 50;
//  3120 = 20 + 31 * 10^2

  @Test
  void karatsuba(){
    log.info("result : {}", (n << 1) + (n << 3));

    addTo(a, b, 2);
    log.info("a : {}", a);
  }

  void addTo(List<Integer> a, List<Integer> b, int k) {
    int aInt = parseArrayToInt(a);
    int bInt = parseArrayToInt(b);
    aInt += (bInt << 1) + (bInt << 3);

//    bInt * 100 = (bInt * 2) + (bInt * 8)
//
//        100 =
//
//    parseIntToArray(aInt, a);

  }

  int parseArrayToInt(List<Integer> a) {
    int aInt =0;
    for (int i = 0; i < a.size(); i++) {
      aInt += a.get(a.size() -1 - i) * Math.pow(10, i);
    }
    return aInt;
  }
  void parseIntToArray(int value, List<Integer> a){
    a.clear();
    Stack<Integer> stack = new Stack<>();
    while(value > 0){
      stack.add(value %10);
      value /= 10;
    }
    int size = stack.size();
    for(int i = 0; i < size; i++){
      a.add(stack.pop());
    }
  }

  void subFrom(List<Integer> a, List<Integer> b) {

  }
}
