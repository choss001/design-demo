package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class _217 {
  int board[][] = {
      {2,5,1,6,1,4,1},
      {6,1,1,2,2,9,3},
      {7,2,3,2,1,3,1},
      {1,1,3,1,7,1,2},
      {4,1,2,3,4,1,2},
      {3,3,1,2,3,4,1},
      {1,5,2,9,4,7,0}
  };
  int n = 7;
  @Test
  void test1(){
    boolean b = jump1(0, 0);
    log.info("result : {}", b);

  }
  int[][] cache;

  private int jump2(int y, int x){
    return 0;
  }
  private boolean jump1(int y, int x){
    if(y >= n || x >= n) return false;
    if(y == n-1 && x == n-1) return true;
    int jumpSize = board[y][x];
    return jump1(y + jumpSize, x) || jump1(y, x + jumpSize);
  }
}
