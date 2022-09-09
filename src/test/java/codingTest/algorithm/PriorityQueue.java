package codingTest.algorithm;
import org.junit.jupiter.api.Test;

import java.util.*;

class PriorityQueueTest {
  PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());

  public long solution(long n) {
    long answer = 0;
    while(n>0){
      queue.add(n%10);
      n/=10;
    }

    StringBuilder result = new StringBuilder();
//    for(Long value : queue){
//      System.out.println("why : "+ value);
//      result.append(value);
//    }
    String value = "";
    value.toCharArray();

    Integer valueInt = 6;
    int[] integers = queue
        .stream()
        .mapToInt(Long::intValue)
        .toArray();

    int size = queue.size();
    for(int i = 0; i < size; i++){
      result.append(queue.poll());
    }


    return Long.parseLong(result.toString());
  }

  @Test
  void test1(){
    solution(10000023);
  }
}