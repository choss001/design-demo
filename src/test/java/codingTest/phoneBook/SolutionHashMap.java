package codingTest.phoneBook;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionHashMap {

  public boolean solution(String[] phone_book) {
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < phone_book.length; i++) {
      map.put(phone_book[i], 1);
    }

    for(int i =0; i<phone_book.length; i++){
      for(int j = 1; j<phone_book[i].length(); j++){
        if(map.containsKey(phone_book[i].substring(0,j)))
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] phone_book = {"119", "97674223", "1195524421"};
    SolutionHashMap sol = new SolutionHashMap();
    System.out.println(sol.solution(phone_book));
  }
}
