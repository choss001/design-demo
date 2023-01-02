package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class TravelPathtest_4 {

    private static final String[][] ticketsInput = new String[][]{
            {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
    };
    private static final String[] resultValue = new String[]{
            "ICN", "JFK", "HND", "IAD"
    };

    @Test
    void test() {
        String[] solution = solution(ticketsInput);
        Assertions.assertArrayEquals(solution, resultValue);
        Stream.of(resultValue).forEach(i -> System.out.printf("%s ", i));
    }

    private List<String> answerStrList = new ArrayList<>();
    private boolean[] used;
    private String[][] tickets;

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        this.tickets = tickets;

        recursive("ICN", "ICN", 0);

        Collections.sort(answerStrList);
        return answerStrList.get(0).split(" ");
    }

    private void recursive(String start, String mergeStr, int count) {
        if (count == tickets.length) {
            this.answerStrList.add(mergeStr);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && used[i] == false) {
                used[i] = true;
                recursive(tickets[i][1], mergeStr + " " + tickets[i][1], count + 1);
                used[i] = false;
            }
        }
    }
}
