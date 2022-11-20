package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
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
    subFrom(b, a);
    log.info("a : {}", b);
  }
  private List<Integer> karatsuba(List<Integer> a, List<Integer> b){
    int an = a.size();
    int bn = b.size();
    if(an < bn) return karatsuba(b, a);
    if(an == 0 || bn == 0) return new ArrayList<>();
    if(an <= 50) return multiply(a, b);
            return null;
  }
  private List<Integer> multiply(List<Integer> a, List<Integer> b){
    int aInt = parseArrayToInt(a);
    int bInt = parseArrayToInt(b);
    parseIntToArray(aInt * bInt, a);
    return a;
  }

  void addTo(List<Integer> a, List<Integer> b, int k) {
    int aInt = parseArrayToInt(a);
    int bInt = parseArrayToInt(b);
//    aInt += (bInt << 1) + (bInt << 3);
    bInt = powOfTen(k, bInt);
    int sum = aInt + bInt;
    parseIntToArray(sum, a);
  }
  private int powOfTen(int size, int value){
    for (int i = 0; i < size; i++) {
      value = (value << 1) + (value << 3);
    }
    return value;
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
    int aInt = parseArrayToInt(a);
    int bInt = parseArrayToInt(b);
    int minus = aInt - bInt;
    parseIntToArray(minus, a);
  }
}
