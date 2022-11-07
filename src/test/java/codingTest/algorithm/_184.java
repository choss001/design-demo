package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class _184 {

  @Test
  void test1() {
    // 12* 34
    int[] a = {2, 1};
    int[] b = {4, 3};
    List<Integer> multiply = multiply(a, b);
    log.info("result : {}", multiply);
  }

  List<Integer> multiply(int[] a, int[] b) {
    int[] c = new int[a.length * b.length + 1];
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < b.length; j++)
        c[i + j] += a[i] * b[j];

    return normalize(Arrays.stream(c).boxed().collect(Collectors.toList()));
  }

  private List<Integer> normalize(List<Integer> num) {
    num.add(0);
    for (int i = 0; i < num.size() -1; i++)
      if(num.get(i) < 0){
        int borrow = (Math.abs(num.get(i)) + 9) / 10;
        num.set(i+1, num.get(i+1) - borrow);
        num.set(i, num.get(i) + borrow * 10);
      }else{
        num.set(i + 1, num.get(i + 1) + num.get(i) / 10);
        num.set(i, num.get(i) % 10);
      }
    while (num.size() > 1 && num.get(num.size() - 1) == 0) {
      num.remove(num.size() -1);
    }
    return num;
  }

  @Test
  void regexNegativeLookahead(){
    String test = "ayaye";
    String regexTest = "^(aya)+(ye)+$";
    Pattern pattern = Pattern.compile(regexTest);
    Matcher matcher= pattern.matcher(test);
    matcher.find();
    log.info("result : {}", matcher.group());
    log.info("matches result :{}", test.matches(regexTest));

  }
  @Test
  void test2(){
    String test = "aya";
  }
}
