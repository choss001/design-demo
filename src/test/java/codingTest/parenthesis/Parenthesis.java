package codingTest.parenthesis;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class Parenthesis {
  boolean solution(String s) {
    boolean answer = false;
    int count = 0;
    for(int i = 0; i<s.length();i++){
      if(s.charAt(i) == '('){
        count++;
      }
      if(s.charAt(i) == ')'){
        count--;
      }
      if(count < 0){
        break;
      }
    }
    if(count == 0){
      answer = true;
    }

    return answer;
  }
}