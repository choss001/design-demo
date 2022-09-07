package codingTest.natureNumReverse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
class Solution {
  private Stack<Long> stack = new Stack<>();
  private Queue<Long> queue = new LinkedList<>();

  public int[] solution(long n) {
    while(n>0){
      System.out.println("loop in : "+ n%10);
      queue.add(n%10);
      System.out.println("queu peek :  " + queue.peek());
      n = n/10;
    }

    int[] answer = new int[queue.size()];
    System.out.println("stack size : "+ queue.size());
    for(int i=0; i< queue.size(); i++){
      System.out.println("why : "+queue.peek() );
      answer[i] = queue.poll().intValue();
    }

    return answer;
  }

  @Test
  void test1() {
    int[] solution = solution(12345L);
    log.info("test : {}", solution);
    String s = "";

  }
}