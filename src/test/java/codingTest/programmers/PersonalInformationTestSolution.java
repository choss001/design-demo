package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class PersonalInformationTestSolution {

    private String today = "2022.05.19";
    private String[] terms =
            {"A 6", "B 12", "C 3"};
    private String[] privacies =
            {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    @Test
    void test(){
        log.info("result : {}", solution(today, terms, privacies));
        List<Integer> integer = new ArrayList<>();
        integer.add(5);
        integer.add(8);
        integer.add(80);

        integer.stream().mapToInt(i -> i).toArray();

    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
