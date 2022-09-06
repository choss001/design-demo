package codingTest.kakao.character;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Slf4j
class SolutionTwoTest {
  static HashMap<Character, Integer> map = new HashMap<>();
  static char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

  public static String solution(String[] survey, int[] choices) {
    String answer = "";
    char[][] words = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    for (int i = 0; i < type.length; i++) {
      map.put(type[i],0);
    }
    for (int i = 0; i < survey.length; i++) {
      if(choices[i] < 4){
        int value = 2;
        if(choices[i] == 1) value = 3;
        else if(choices[i] == 3) value = 1;
        map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+value);
      }else if(choices[i] > 4){
        map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+choices[i]-4);
      }
    }

    for (int i = 0; i < words.length; i++) {
      char[] word = words[i];
      if(map.get(word[0]) < map.get(word[1])) answer += word[1];
      else if(map.get(word[0]) > map.get(word[1])) answer += word[0];
      else {
        answer += (char)Math.min(word[0], word[1]);
      }

    }

    return answer;
  }

  @Test
  void test1(){
    String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
    int[] choices = {5, 3, 2, 7, 5};
    log.info("test : {} ",solution(survey, choices));
  }
}
