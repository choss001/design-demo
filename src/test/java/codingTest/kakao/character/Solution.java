package codingTest.kakao.character;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.*;

@Slf4j
class Solution {
  private Map<String, String> table = new HashMap<>();

  public String solution(String[] survey, int[] choices) {
    String statusString = "RTCFJMAN";

    recursive("", statusString, 2);

    String[] findKey = new String[survey.length];
    for(int i =0; i < survey.length; i++){

      findKey[i] = survey[i] + " " + choices[i];
    }

    HashMap<String, Integer> map = new HashMap<>();


    for(String value : findKey){
      map.put(String.valueOf(table.get(value).charAt(0)), Integer.valueOf(table.get(value).charAt(2)));
    }


    String answer = "";
    answer = map.getOrDefault("R", 0) >= map.getOrDefault("T",0)? "R":"T";
    answer = map.getOrDefault("C", 0) >= map.getOrDefault("F",0)? answer+"R":answer+"T";
    answer = map.getOrDefault("J", 0) >= map.getOrDefault("M",0)? answer+"J":answer+"M";
    answer = map.getOrDefault("A", 0) >= map.getOrDefault("N",0)? answer+"A":answer+"N";

    String test = table.keySet().stream().collect(Collectors.joining(";"));

    return table.values().stream().collect(Collectors.joining(":"));
  }


  private void recursive(String comp, String others, int count){
    if(count == 0){
      return;
    }

    if(comp.length() == 2){
      for(int i= 1; i < 8; i++){
        if(i < 5){
          table.put(comp+" "+i, comp.charAt(1)+ " "+Math.abs(i-4));
        }else{
          table.put(comp+" "+i, comp.charAt(0)+" "+(i-4));
        }
      }
    }

    for(int i=0; i < others.length(); i++){
      recursive(comp+ others.charAt(i), others.substring(0, i) + others.substring(i+1), count--);
    }
  }

  @Test
  void test1(){
    String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
    int[] choices = {5, 3, 2, 7, 5};
    log.info("test : {} ",solution(survey, choices));
  }
}