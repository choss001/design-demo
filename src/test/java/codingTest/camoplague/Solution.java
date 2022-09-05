package codingTest.camoplague;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Solution {

  public int solution(String[][] clothes) {
    HashMap<String, Integer> map = new HashMap<>();

    for (String[] clothe : clothes) {
      String type = clothe[1];
      map.put(type, map.getOrDefault(type, 0) + 1);
    }
    Set<Map.Entry<String, Integer>> set = map.entrySet();
    Iterator<Map.Entry<String, Integer>> it = set.iterator();

    int result = 1;
    while(it.hasNext()){
      result *= (it.next().getValue() + 1);
    }
    return result -1;

  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    String[][] clothes = {
        {"yellowhat", "headgear"},
        {"bluesunglasses", "eyewear"},
        {"green_turban", "headgear"}
    };

    System.out.println(sol.solution(clothes));
  }
}
