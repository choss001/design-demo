package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _222WildCard {

    String W;
    String S;
    private static int count = 0;
    @Test
    void test1(){
        String wildCard = "*bb*";
        String word = "babbc";

        W = wildCard;
        S = word;

        boolean match = match(wildCard, word);
        cacheset();
//        boolean match = matchMemoized(0, 0);
//        boolean match = matchMemoizedBetter(0, 0);
        log.info("result : {}", match);
        log.info("count : {}", count);

    }

    private boolean match(String w, String s) {
        count++;
        int pos =0;
//        String[] wArray = w.split("");
////        String[] sArray = s.split("");
        while(pos < s.length() && pos < w.length() &&
                (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
            ++pos;
        if (pos == w.length())
            return pos == s.length();

        if(w.charAt(pos) == '*')
            for(int skip = 0; pos+skip <= s.length(); ++skip)
                if(match(w.substring(pos+1), s.substring(pos+skip)))
                    return true;
        return false;
    }

    int[][] cache = new int[101][101];

    private boolean matchMemoized(int w, int s) {
        count++;
        int ret = cache[w][s];
        if(ret != -1) return cache[w][w] == 1 ? true : false;
        while (s < S.length() && w < W.length() &&
                (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
            ++w;
            ++s;
        }
        if(w == W.length()){
            cache[w][s] = (s == S.length()) ? 1 : 0;
            return (s == S.length());
        }
        if (W.charAt(w) == '*')
            for (int skip = 0; skip + s <= S.length(); ++skip)
                if(matchMemoized(w+1, s+skip)){
                    return (cache[w][s] = 1) == 1;
                }
        cache[w][s] = 0;
        return  false;

    }
    private void cacheset(){
        for(int i =0; i < cache.length; i++)
            for(int j =0; j < cache[0].length; j++)
                cache[i][j] = -1;

    }

    private boolean matchMemoizedBetter(int w, int s) {
        int ret = cache[w][s];
        if(ret != -1) return cache[w][w] == 1 ? true : false;
        while (s < S.length() && w < W.length() &&
                (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
            boolean b = matchMemoizedBetter(w + 1, s + 1);
            cache[w][s] = b == true ? 1 : 0;
            return b;
        }
        if(w == W.length()){
            cache[w][s] = (s == S.length()) ? 1 : 0;
            return (s == S.length());
        }
        if (W.charAt(w) == '*')
            if(matchMemoizedBetter(w+1, s) ||
                    (s < S.length() && matchMemoizedBetter(w, s+1))){
                cache[w][s] = 1;
                return true;
            }
        cache[w][s] = 0;
        return  false;

    }
}
