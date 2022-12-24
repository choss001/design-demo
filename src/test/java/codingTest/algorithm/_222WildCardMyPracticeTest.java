package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class _222WildCardMyPracticeTest {

    //    private static final String W = "a*b*c*e*b";
    private static final String W = "a*b*a";
    private static final String S = "abbccs";
    private int[][] cache = new int[101][101];
    private static int count = 0;

    @Test
    void test() {
        boolean matchV1 = match(W, S);
        log.info("result : {}", matchV1);
        log.info("match method count : {}", count);
    }

    private boolean matchV1(String w, String s) {
        count++;
        makeCache();
        int pos = 0;
        while (pos < w.length() && pos < s.length()
                && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
            ++pos;
        }
        if (cache[pos][pos] != -1)
            return cache[pos][pos] == 1 ? true : false;
        if (pos == w.length())
            return true;

        //
        if (w.charAt(pos) == '*') {
            if (pos == w.length() - 1)
                return true;
            for (int i = 1; pos + i < s.length(); i++) {
                if (cache[pos + 1][pos + i] == -1) {
                    if (match(w.substring(pos + 1), s.substring(pos + i))) {
                        cache[pos + 1][pos + i] = 1;
                        return true;
                    }
                } else
                    return cache[pos + 1][pos + i] == 1 ? true : false;
            }
        }
        //3 *bc pos =0
        cache[pos][pos] = -1;
        return false;
    }

    private boolean match(String w, String s) {
        count++;
        int pos = 0;
        while (pos < w.length() && pos < s.length()
                && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
            ++pos;
        }
        if (pos == w.length())
            return true;

        //
        if (w.charAt(pos) == '*') {
            if (pos == w.length() - 1)
                return true;
            for (int i = 1; pos + i < s.length(); i++) {
                    if (match(w.substring(pos + 1), s.substring(pos + i)))
                        return true;
            }
        }
        return false;
    }

    private void makeCache() {
        for (int i = 0; i < cache.length; i++)
            for (int j = 0; j < cache.length; j++)
                cache[i][j] = -1;
    }

    @Test
    void test2(){
        List<String> list = new ArrayList<>();
    }

    /**
     * 글자가 맞으면 넘긴다 안맞으면 while이 끝
     * while이 끝까지 다 맞아서 넘거아면 트루
     * '*'일때는 한번 더 재귀를 태워서 반복 검사
     */
}
