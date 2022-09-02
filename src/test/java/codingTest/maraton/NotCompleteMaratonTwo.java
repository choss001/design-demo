package codingTest.maraton;

import java.util.*;

public class NotCompleteMaratonTwo {

  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> hm = new HashMap<>();
    for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
    for (String player : completion) hm.put(player, hm.get(player) - 1);

//    for (String key : hm.keySet()) {
//      if (hm.get(key) != 0) {
//        answer = key;
//        break;
//      }
//    }

    Iterator<Map.Entry<String,Integer>> iter = hm.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      if(entry.getValue() != 0){
        answer = entry.getKey();
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    String[] part = {"leo", "kiki", "eden"};
    String[] comp = {"eden", "kiki"};
    NotCompleteMaratonTwo ncm = new NotCompleteMaratonTwo();
    System.out.println(ncm.solution(part, comp));

  }
}
