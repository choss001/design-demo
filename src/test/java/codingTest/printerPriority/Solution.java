package codingTest.printerPriority;

import java.util.*;

class Solution {
  public int solution(int[] priorities, int location) {
    // 1. List로 만들기
    List<PrintJob> printer = new ArrayList<PrintJob>();
    for (int i = 0; i < priorities.length; i++)
      printer.add(new PrintJob(i, priorities[i]));

    int turn = 0;
    while (!printer.isEmpty()) {
      // 2. 0번을 꺼내서 max priority가 아니면 다시 끝에 넣기
      PrintJob job = printer.remove(0);
      if (printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
        printer.add(job);
      } else {
        turn++;
        // 3. max Priority가 맞다면 내가 찾는 job이 맞는지 확인하기
        if (location == job.location)
          break;
      }
    }

    return turn;
  }

  class PrintJob {
    int priority;
    int location;

    public PrintJob(int location, int priority) {
      this.location = location;
      this.priority = priority;
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] priorities = { 2, 1, 3, 2 };
    System.out.print(sol.solution(priorities, 2));
  }
}