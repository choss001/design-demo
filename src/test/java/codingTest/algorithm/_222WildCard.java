package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _222WildCard {

    @Test
    void test1(){
        String wildCard = "*bb*";
        String word = "babbc";
        boolean match = match(wildCard, word);
        log.info("result : {}", match);

    }

    private boolean match(String w, String s) {
        int pos =0;
//        String[] wArray = w.split("");
////        String[] sArray = s.split("");
        while(pos < s.length() && pos < w.length() &&
        w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))
            ++pos;
        if (pos == w.length())
            return pos == s.length();

        if(w.charAt(pos) == '*')
            for(int skip = 0; pos+skip <= s.length(); ++skip)
                if(match(w.substring(pos+1), s.substring(pos+skip)))
                    return true;
        return false;
    }
}
