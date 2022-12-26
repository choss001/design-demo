package codingTest.programmers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class TravelPathTest {

//    private static final String[][] input = {
//            {"ICN", "JFK"},
//            {"HND", "IAD"},
//            {"JFK", "HND"}
//    };

    private static final String[][] input = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    private static final String[] answer = {"ICN", "JFK", "HND", "IAD"};

    private static List<String> answerList = new ArrayList<>();

    @Test
    void test1() throws JsonProcessingException {
        String[] solution = solution(input);
        log.info("result : {}", solution);
    }


    public String[] solution(String[][] tickets) throws JsonProcessingException {
        String[] answer = {};
        List<List<List<String>>> queue = initialList(tickets);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(queue);
        log.info("result : {}", s);
        return answer;
    }

    private void recursive(List<List<List<String>>> input){
    }

    //모든 알파벳은 같을수 없다는 가정
    private boolean firstIsBigger(String f, String s){
        for(int i =0; i < 3; i++){
            if(f.charAt(i) < s.charAt(i))
                return true;
        }
        return false;
    }
    private List<List<List<String>>> initialList(String[][] tickets){
        List<List<List<String>>> list = new ArrayList<>();
        for(int i =0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                List<List<String>> second = new ArrayList<>();
                List<String> first = new ArrayList<>();
                first.add(tickets[i][0]);
                first.add(tickets[i][1]);
                second.add(first);
                list.add(second);
                List<List<String>> secondOther = new ArrayList<>();
                for(int j =0; j < tickets.length; j++){
                    if(j != i)    {
                        System.out.println("in?");
                        List<String> firstOther = new ArrayList<>();
                        firstOther.add(tickets[j][0]);
                        firstOther.add(tickets[j][1]);
                        secondOther.add(firstOther);
                    }
                }
                list.add(secondOther);
            }
        }
        return list;
    }}
