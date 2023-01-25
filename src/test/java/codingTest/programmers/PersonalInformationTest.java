package codingTest.programmers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonalInformationTest {

    @Test
    void tes1(){
//        solution();
    }

    List<Integer> answerList = new ArrayList<>();
    private String today;

    private HashMap<String, Integer> termMap = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        settingTerm(terms);
        this.today = today;

        mappingValues(privacies);
        int[] answer = new int[answerList.size()];
        for(int i =0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    private void mappingValues(String[] privacies){
        for(int i =0; i < privacies.length; i++){
            String[] privaciesSplit = privacies[i].split(" ");
            calculate(plusTerm(privaciesSplit[0], privaciesSplit[1]), i);
        }
    }
    private void calculate(int[] plusMonth, int i){
        int[] todayArray = today();
        LocalDate today =
                LocalDate.of(todayArray[0], todayArray[1], todayArray[2]);
        LocalDate target =
                LocalDate.of(plusMonth[0], plusMonth[1], plusMonth[2]);
        if(today.isAfter(target))
            answerList.add(i + 1);
    }
    private int[] today(){
        String[] targetDayArray = today.split("\\.");
        Integer year = Integer.valueOf(targetDayArray[0]);
        Integer month = Integer.valueOf(targetDayArray[1]);
        Integer day = Integer.valueOf(targetDayArray[2]);

        int[] result = new int[3];
        result[0] = year;
        result[1] = month;
        result[2] = day;

        return result;
    }


    private void settingTerm(String[] terms){
        for(int i =0; i < terms.length; i++){
            String[] termArray = terms[i].split(" ");
            termMap.put(termArray[0], Integer.valueOf(termArray[1]));
        }
    }

    private int[] plusTerm(String targetDay, String termEnglish){
        String[] targetDayArray = targetDay.split("\\.");
        Integer year = Integer.valueOf(targetDayArray[0]);
        Integer month = Integer.valueOf(targetDayArray[1]);
        Integer day = Integer.valueOf(targetDayArray[2]);

        month += termMap.get(termEnglish);
        if(month > 12){
            year += month/12;
            month %= 12;
            if(month == 0){
                year -= 1;
                month = 12;
            }
        }
        day -= 1;
        if(day < 1){
            month -=1;
            day = 28;
            if(month == 0){
                year -= 1;
                month = 12;
            }
        }

        int[] result = new int[3];
        result[0] = year;
        result[1] = month;
        result[2] = day;
        return result;
    }
}
