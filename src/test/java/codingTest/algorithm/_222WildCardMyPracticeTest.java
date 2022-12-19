package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _222WildCardMyPracticeTest {

    private static final String W = "*bb*";
    private static final String S = "abbccedssb";
    private int[][] cache = new int[101][101];

    @Test
    void test(){
        boolean match = match();
        log.info("result : {}", match);
    }
    private boolean match(String w, String s){
        int pos = 0;
         while(pos < w.length() && pos < s.length()
                 && (w.charAt(pos) == s.charAt(pos))){
             ++pos;
         }
         if(pos == w.length() && pos == s.length())
            return true;

         if(w.charAt(pos) == '*'){
             for(int i =0; i < w.length(); i++){
                if(match("S","W"))
                    return true;
             }
         }
         return false;
    }

    /**
     * 글자가 맞으면 넘긴다 안맞으면 while이 끝
     * while이 끝까지 다 맞아서 넘거아면 트루
     * '*'일때는 한번 더 재귀를 태워서 반복 검사
     */
}
