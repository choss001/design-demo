package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Stack;

@Slf4j
public class PaperMarioTest {
  int[][] board = {
      {0, 1, 0, 1},
      {0, 1, 0, 0},
      {0, 0, 0, 1},
      {1, 1, 1, 0},
      {1, 0, 0, 0},
      {0, 1, 1, 0},
      {1, 0, 0, 0},
      {0, 0, 0, 0},
      {1, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
  };
  int maxCount = 3;
  Stack<String> process = new Stack<>();

  @Test
  void test1() {
    recursive(maxCount, process);
  }

  private void recursive(int maxCount, Stack<String> process) {
    if (checkSuccess()) {
      log.info("SUCCESS: {} ", process);
      return;
    }
    if (maxCount == 0)
      return;
    transverse(maxCount, process);
    vertical(maxCount, process);
  }

  private void transverse(int maxCount, Stack<String> process) {
    maxCount--;
    for (int i = 0; i < 11; i++) {
      if(allEmptyRow(i))
        continue;
      for (int j = 0; j < 8; j++) {
        moveRight(i, j);
        process.add("오른쪽 로우 :" + i + ", 횟수 :" + (j+1) +"\n");
        recursive(maxCount, process);
        process.pop();
        moveLeft(i, j);
      }
    }
  }

  private void vertical(int maxCount, Stack<String> process) {
    maxCount--;
    for (int i = 0; i < 4; i++) {
      if(allEmptyColumn(i))
        continue;
      for (int j = 0; j < 11; j++) {
        moveUpward(i, j);
        process.add("위쪽 컬럼 : " + i + ", 횟수 : " + (j+1) +"\n");
        recursive(maxCount, process);
        process.pop();
        moveDownward(i, j);
      }
    }
  }

  private boolean checkSuccess() {
    boolean result = true;
    for (int i = 0; i < 12; i++) {
      if (board[i][2] == 1) {
        if (!(board[i][0] == 1 && board[i][1] == 1 && board[i][3] == 1)) {
          checkReset();
          return false;
        }
        board[i][0] = board[i][1] = board[i][2] = board[i][3] = 2;
      }
    }
    for (int i = 0; i < 11; i++) {
      if (board[i][1] == 1) {
        if (!(board[i][0] == 1 && board[i + 1][0] == 1 && board[i + 1][1] == 1)) {
          checkReset();
          return false;
        }
        board[i][0] = board[i][1] = board[i + 1][0] = board[i + 1][1] = 2;
      }
    }
    if (board[11][1] == 1) {
      if (!(board[11][0] == 1 && board[0][0] == 1 && board[0][1] == 1)) {
        checkReset();
        return false;
      }
    }
    //남은 1짜리가 있는지
    for(int i =0; i < 4; i++)
      for(int j = 0; j < 12; j++)
        if(board[j][i] == 1){
          checkReset();
          return false;
        }

    checkReset();
    return result;
  }

  private void checkReset() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 12; j++) {
        if (board[j][i] == 2)
          board[j][i] = 1;
      }
    }
  }

  private void moveRight(int row, int count) {
    //0 6, 6 12, 6 0, 7 1,
    for (int i = 0; i <= count; i++) {
      int counterPart = (row + 6) % 12;
      int[] temp = {board[row][0], board[row][1], board[row][2], board[row][3],
          board[counterPart][0], board[counterPart][1], board[counterPart][2], board[counterPart][3]};
      board[row][0] = temp[7];
      board[row][1] = temp[0];
      board[row][2] = temp[1];
      board[row][3] = temp[2];
      board[counterPart][0] = temp[3];
      board[counterPart][1] = temp[4];
      board[counterPart][2] = temp[5];
      board[counterPart][3] = temp[6];
    }
  }

  private void moveLeft(int row, int count) {
    int counterPart = (row + 6) % 12;
    for (int i = 0; i <= count; i++) {
      int[] temp = {board[row][0], board[row][1], board[row][2], board[row][3],
          board[counterPart][0], board[counterPart][1], board[counterPart][2], board[counterPart][3]};
      board[row][0] = temp[1];
      board[row][1] = temp[2];
      board[row][2] = temp[3];
      board[row][3] = temp[4];
      board[counterPart][0] = temp[5];
      board[counterPart][1] = temp[6];
      board[counterPart][2] = temp[7];
      board[counterPart][3] = temp[0];
    }
  }

  private void moveDownward(int column, int count) {
    for (int i = 0; i <= count; i++) {
      int[] temp = {board[0][column], board[1][column], board[2][column], board[3][column], board[4][column], board[5][column],
          board[6][column], board[7][column], board[8][column], board[9][column], board[10][column], board[11][column]};
      board[0][column] = temp[11];
      board[1][column] = temp[0];
      board[2][column] = temp[1];
      board[3][column] = temp[2];
      board[4][column] = temp[3];
      board[5][column] = temp[4];
      board[6][column] = temp[5];
      board[7][column] = temp[6];
      board[8][column] = temp[7];
      board[9][column] = temp[8];
      board[10][column] = temp[9];
      board[11][column] = temp[10];
    }

  }

  private void moveUpward(int column, int count) {
    for (int i = 0; i <= count; i++) {
      int[] temp = {board[0][column], board[1][column], board[2][column], board[3][column], board[4][column], board[5][column],
          board[6][column], board[7][column], board[8][column], board[9][column], board[10][column], board[11][column]};
      board[0][column] = temp[1];
      board[1][column] = temp[2];
      board[2][column] = temp[3];
      board[3][column] = temp[4];
      board[4][column] = temp[5];
      board[5][column] = temp[6];
      board[6][column] = temp[7];
      board[7][column] = temp[8];
      board[8][column] = temp[9];
      board[9][column] = temp[10];
      board[10][column] = temp[11];
      board[11][column] = temp[0];
    }

  }
  private boolean allEmptyRow(int row){
    for(int i =0; i < 4; i++){
      int counterPart = (row + 6) % 12;
      if(board[row][i] == 1)
        return false;
      if(board[counterPart][i] == 1)
        return false;
    }
    return true;
  }
  private boolean allEmptyColumn(int column){
    for(int i =0; i < 12; i++){
      if(board[i][column] == 1)
        return false;
    }
    return true;

  }
}
