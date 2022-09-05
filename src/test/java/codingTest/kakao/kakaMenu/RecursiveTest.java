package codingTest.kakao.kakaMenu;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.*;

import java.util.*;
import java.util.stream.*;

@Slf4j
class RecursiveTest {
  Set<String> set = new HashSet<>();
  Map<String,Integer> hashMap = new HashMap<>();

  public String[] solution(String[] orders, int[] course) {
    for(String value : orders){
      recursive("",sortString(value));
      saveHashMap(set);
      set.clear();
    }
    removeHashMapValueOne(course);
    String[] answer = hashMap.keySet().toArray(new String[0]);
    Arrays.sort(answer);
    return answer;

  }

  @Test
  void test1(){
    String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    int[] course = {2, 3, 4};
    log.info("result : {}", solution(orders, course));
  }

  private void removeHashMapValueOne(int[] course){
    Iterator<Map.Entry<String,Integer>> entry = hashMap.entrySet().iterator();
    while(entry.hasNext()){
      Map.Entry<String,Integer> mapEntry = entry.next();

      if(!Arrays
          .stream(course)
          .anyMatch(value -> value == mapEntry.getKey().length())){

        entry.remove();
      }else{
        if(mapEntry.getValue() <= 1)
          entry.remove();
      }
    }
  }

  private void recursive(String composition, String others){
    if(!composition.isEmpty() && composition.length() != 1)
      set.add(composition);

    for(int i =0; i <others.length(); i++){
      recursive(composition+others.charAt(i), others.substring(i+1));
    }
  }
  private String sortString(String string){
    char[] charArray = string.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }

  private void saveHashMap(Set<String> set){
    Iterator<String> iterator= set.iterator();
    while(iterator.hasNext()){
      String value = iterator.next();
      hashMap.put(value, hashMap.getOrDefault(value, 0) +1);
    }
  }

}