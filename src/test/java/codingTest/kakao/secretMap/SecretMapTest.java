package codingTest.kakao.secretMap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class SecretMapTest {

  int n = 0;
  int[] arr1 = null;
  int[] arr2 = null;

  @Test
  void test1(){
    int n = 5;
    int[] arr1 = {9,20,28,18,11};
    int[] arr2 = {30,1,21,17,28};
    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
    }

    for (int i = 0; i < n; i++) {
      result[i] = String.format("%" + n + "s", result[i]);
      result[i] = result[i].replaceAll("1", "#");
      result[i] = result[i].replaceAll("0", " ");
    }

    Arrays.stream(result).forEach(System.out::println);

  }

  @Test
  void test2(){
    String tes = "#";
    System.out.println(String.format("\"%03d\"", 5));
    System.out.println(String.format("\"%-3d\"", 5));
  }
}
