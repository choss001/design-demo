package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.lang.Math.*;

@Slf4j
public class Karatsuba {

  private List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,2,2,2,5, 1));
  private List<Integer> b = new ArrayList<>(Arrays.asList(1, 6, 3,3,3,3,2,1));
  // 12322251 * 16333321;
  private int n = 50;
//  3120 = 20 + 31 * 10^2

  @Test
  void karatsuba(){
//    subFrom(b, a);
//    log.info("a : {}", b);
    List<Integer> karatsuba = karatsuba(a, b);
    log.info("result : {}", karatsuba);
  }
  @Test
  void test () {
    long result = 12322251L * 16333321;
    log.info("result : {}", result);
  }
  private List<Integer> karatsuba(List<Integer> a, List<Integer> b){
    int an = a.size();
    int bn = b.size();
    if(an < bn) return karatsuba(b, a);
    if(an == 0 || bn == 0) return new ArrayList<>();
    if(an <= 50) return multiply(a, b);
    int half = an / 2;
    List<Integer> a0 = new ArrayList<>(a.subList(0, half));
    List<Integer> a1 = new ArrayList<>(a.subList(half, a.size()));
    List<Integer> b0 = new ArrayList<>(b.subList(0, min(b.size(), half)));
    List<Integer> b1 = new ArrayList<>(b.subList(min(b.size(), half), b.size()));
    List<Integer> z2 = karatsuba(a1, b1);
    List<Integer> z0 = karatsuba(a0, b0);

    addTo(a0, a1, 0);
    addTo(b0, b1, 0);
    List<Integer> z1 = karatsuba(a0, b0);
    subFrom(z1, z0);
    subFrom(z1, z2);
    List<Integer> ret = new ArrayList<>();
    addTo(ret, z0, 0);
    addTo(ret, z1, half);
    addTo(ret, z2, half + half);
    return ret;
  }
  private List<Integer> multiply(List<Integer> a, List<Integer> b){
    Long aInt = parseArrayToInt(a);
    Long bInt = parseArrayToInt(b);
    parseIntToArray(aInt * bInt, a);
    return a;
  }

  void addTo(List<Integer> a, List<Integer> b, int k) {
    Long aInt = parseArrayToInt(a);
    Long bInt = parseArrayToInt(b);
//    aInt += (bInt << 1) + (bInt << 3);
    bInt = powOfTen(k, bInt);
    Long sum = aInt + bInt;
    parseIntToArray(sum, a);
  }
  private Long powOfTen(int size, Long value){
    for (int i = 0; i < size; i++) {
      value = (value << 1) + (value << 3);
    }
    return value;
  }

  Long parseArrayToInt(List<Integer> a) {
    Long aInt =0L;
    for (int i = 0; i < a.size(); i++) {
      aInt += Double.valueOf(a.get(a.size() -1 - i) * pow(10, i)).longValue();
    }
    return aInt;
  }
  void parseIntToArray(Long value, List<Integer> a){
    a.clear();
    Stack<Integer> stack = new Stack<>();
    while(value > 0){
      stack.add((int) (value %10));
      value /= 10;
    }
    int size = stack.size();
    for(int i = 0; i < size; i++){
      a.add(stack.pop());
    }
  }

  void subFrom(List<Integer> a, List<Integer> b) {
    Long aInt = parseArrayToInt(a);
    Long bInt = parseArrayToInt(b);
    Long minus = aInt - bInt;
    parseIntToArray(minus, a);
  }
}
