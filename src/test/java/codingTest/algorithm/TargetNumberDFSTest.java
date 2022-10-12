package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TargetNumberDFSTest {
  private final int[] numbers = {1, 1, 1, 1, 1};
  private int target = 3;

  private int answer = 0;

  @Test
  void solution() {
//    int[] numbers = {1,1,1,1,1};
//    int target = 3;

    dfs(0, 0);


    log.info("answer : {}", answer);
    if (answer == 5) {
      log.info("SUCCESS");
    }

  }
//  index, sum, i
//  0, 0, 0
//  1, 1, 0

  private void dfs(int index, int sum) {
    log.info("index : {}, sum : {}", index, sum);
    if (index == numbers.length) {
      if (sum == target) {
        answer++;
      }
      return;
    }
    dfs(index + 1, sum + numbers[index]);
    dfs(index + 1, sum - numbers[index]);

  }
}
