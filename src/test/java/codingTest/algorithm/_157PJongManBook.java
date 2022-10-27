package codingTest.algorithm;

import org.junit.jupiter.api.Test;

public class _157PJongManBook {

  int n;
  int[][] areFriends = {
      {2, 1},
      {0, 1},
      {4, 6},
      {0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3},
      {6, 10},
      {0, 1, 0, 2, 1, 2, 1, 3, 1, 4, 2, 3, 2, 4, 3, 4, 3, 5, 4, 5}
  };


  @Test
  void test1() {
    n = 3;

  }

  private int countPairings(boolean[] taken) {
    boolean finished = true;
    for (int i = 0; i < n; i++) if (!taken[i]) finished = false;
    if (finished) return 1;
    int ret = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        if (!taken[i] && !taken[j] && areFriends[i][j]) {
          taken[i] = taken[j] = true;
          ret += countPairings(taken);
          taken[i] = taken[j] = false;
        }
      }
    return ret;
  }
}
