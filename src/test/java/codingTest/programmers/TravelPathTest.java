package codingTest.programmers;

import java.util.ArrayList;
import java.util.List;

public class TravelPathTest {

    private static final String[][] input = {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
    };
    private static final String[] answer =
            {"ICN", "JFK", "HND", "IAD"};

    private static List<String> answerList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        System.out.println("test : " + firstIsBigger("BAA", "ABB"));
        return answer;
    }

    private void recursive(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {

        }

    }

    //모든 알파벳은 같을수 없다는 가정
    private boolean firstIsBigger(String f, String s) {
        for (int i = 0; i < 3; i++) {
            if (f.charAt(i) < s.charAt(i))
                return true;
        }
        return false;
    }
}
