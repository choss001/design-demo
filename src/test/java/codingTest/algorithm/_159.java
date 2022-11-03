package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _159 {
  private int[][][] coverType = {
      {{0, 0}, {1, 0}, {0, 1}},
      {{0, 0}, {0, 1}, {1, 1}},
      {{0, 0}, {1, 0}, {1, 1}},
      {{0, 0}, {1, 0}, {1, -1}}
  };
  private int[][] board = {
      {1, 0, 0, 0, 0, 0, 1},
      {1, 0, 0, 0, 0, 0, 1},
      {1, 1, 0, 0, 1, 1, 1},
  };

  @Test
  void test1() {

    log.info("result : {}", cover(board));

  }

  private boolean set(int[][] board, int y, int x, int type, int delta) {

    boolean ok = true;
    for (int i = 0; i < 3; i++) {
      int ny = y + coverType[type][i][0];
      int nx = x + coverType[type][i][1];
      if (ny < 0 || ny >= board.length || nx < 0 ||
          nx >= board[0].length)
        ok = false;
      else if ((board[ny][nx] += delta) > 1)
        ok = false;

    }
    return ok;
  }

  private int cover(int[][] board) {
    int y = -1, x = -1;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++)
        if (board[i][j] == 0) {
          y = i;
          x = j;
          break;
        }
      if (y != -1) break;
    }
    if (y == -1) return 1;
    int ret = 0;
    for (int type = 0; type < 4; type++) {
      if (set(board, y, x, type, 1))
        ret += cover(board);
      set(board, y, x, type, -1);
    }
    return ret;
  }
}

