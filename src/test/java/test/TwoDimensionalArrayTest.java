package test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TwoDimensionalArrayTest {

  @Test
  void test1(){


    int[][] board = {
        { 0, 0, 0, 0 },
        { 0, 0, 6, 0 },
        { 0, 0, 0, 7 },
        { 0, 0, 0, 0 }
    };

    (2, 1);

    log.info("test : {}", board[2][3]);
  }
}
