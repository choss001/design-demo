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


  @Test
  void test2(){

  }

  public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    int box = cap;
    int rbox = cap;
    int max = 0;
    int gostop = 0;
    int backstop = 0;
    while (true) {
      for (int i = n - 1; i > -1; i--) {
        if (deliveries[i] > 0 && max == 0) {
          max = i + 1;
          break;
        } else if (pickups[i] > 0 && max == 0) {
          max = i + 1;
          break;
        }
      }
      for (int i = n - 1; i > -1; i--) {
        if (box > 0 && deliveries[i] > 0) {
          if (deliveries[i] > box) {
            deliveries[i] -= box;
            box = 0;
            gostop = i + 1;
          } else if (deliveries[i] < box) {
            box -= deliveries[i];
            deliveries[i] = 0;
          } else {
            gostop = i;
            box = 0;
            deliveries[i] = 0;
          }
        }
        if (rbox > 0 && pickups[i] > 0) {
          if (pickups[i] > rbox) {
            pickups[i] -= rbox;
            rbox = 0;
            backstop = i + 1;
          } else if (pickups[i] < rbox) {
            rbox -= pickups[i];
            pickups[i] = 0;
          } else {
            backstop = i;
            rbox = 0;
            pickups[i] = 0;
          }
        }
        if (box == 0 && rbox == 0) {
          break;
        }
      }
      if (box == cap && rbox == cap) {
        break;
      } else {
        answer += max;
        n = gostop > backstop ? gostop : backstop;
        box = cap;
        rbox = cap;
        max = 0;
        gostop = 0;
        backstop = 0;
      }
    }
    return answer * 2;
  }
}
