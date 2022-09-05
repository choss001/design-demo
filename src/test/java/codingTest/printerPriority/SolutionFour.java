package codingTest.printerPriority;

import java.util.*;

class SolutionFour {
  private static Queue<Integer> q = new LinkedList<>();
  public int solution(int[] priorities, int location) {

    int answer = 0;
    for(int i= 0; i < priorities.length; i++){
      q.add(priorities[i]);
    }

    Arrays.sort(priorities);

    while(q.isEmpty()){
      int value = q.poll();
      if(value == priorities[(priorities.length-1) -answer]){
        answer ++;
        if(location == 0){
          break;
        }
        location --;

      }else{
        q.add(value);
        location --;
        if(location <0){
          location = q.size() -1;
        }

      }
    }

    return answer;
  }

  public static void main(String[] args) {
    SolutionFour sol = new SolutionFour();
    int[] priorities = { 2, 1, 3, 2 };
    System.out.print(sol.solution(priorities, 2));
  }

}