package codingTest.algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class _157PJongManBook {

  int testcase;
  boolean[] taken = {false, false, false, false, false, false, false, false, false, false};
  boolean[][] areFriends = new boolean[10][10];
  int student;
  //테스트
//두번째 테스트
  @Test
  void test1() {
    testcase = 1;
    int coupleNum = 6;
    student = 4;
    int[] input = {0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3};
    int ret = 0;
//    int[] input = {0,1};
    //12
    for (int i = 0; i < input.length; i += 2) {
      areFriends[input[i]][input[i + 1]] = true;
      areFriends[input[i + 1]][input[i]] = true;
    }

    log.info("testcase : {}", testcase);
    while (testcase > 0) {
      testcase--;
      ret = countPairingsJava(taken);
    }
    log.info("result : {}", ret);


  }

  private int countPairingsJava(boolean[] taken) {
    int firstFree = -1;
    for (int i = 0; i < student; i++) {
      if (!taken[i]) {
        firstFree = i;
        break;
      }
    }
    if (firstFree == -1) return 1;
    int ret = 0;
    for (int pairWith = firstFree + 1; pairWith < student; pairWith++) {
      if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
        taken[firstFree] = taken[pairWith] = true;
        ret += countPairingsJava(taken);
        taken[firstFree] = taken[pairWith] = false;
      }
    }
    return ret;
  }
}
