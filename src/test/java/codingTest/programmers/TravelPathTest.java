package codingTest.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<List<List<List<String>>>> queue = initialList(tickets);
        List<List<List<String>>> list = queue.poll();
        System.out.println("result : "+list.get(0).get(0).get(0) );
        System.out.println("result : "+list.get(0).get(0).get(1) );
        System.out.println("result : "+list.get(0).size() );
        System.out.println("result : "+list.get(0).get(0).size() );

        return answer;
    }

    private void recursive(String[][] tickets){
        for(int i =0; i < tickets.length; i++){

        }

    }

    //모든 알파벳은 같을수 없다는 가정
    private boolean firstIsBigger(String f, String s){
        for(int i =0; i < 3; i++){
            if(f.charAt(i) < s.charAt(i))
                return true;
        }
        return false;
    }
    private Queue<List<List<List<String>>>> initialList(String[][] tickets){
        Queue<List<List<List<String>>>> queue = new LinkedList<>();
        for(int i =0; i < tickets.length; i++){
            List<List<List<String>>> list = new ArrayList<>();
            if(tickets[i][0].equals("ICN")){
                List<List<String>> second = new ArrayList<>();
                List<String> first = new ArrayList<>();
                first.add(tickets[i][0]);
                first.add(tickets[i][1]);
                second.add(first);
                list.add(second);
                for(int j =0; j < tickets.length; j++){
                    List<List<String>> secondOther = new ArrayList<>();
                    if(j != i){
                        List<String> firstOther = new ArrayList<>();
                        firstOther.add(tickets[j][0]);
                        firstOther.add(tickets[j][0]);
                        secondOther.add(firstOther);
                    }
                    list.add(secondOther);
                }
            }
            queue.add(list);
        }
        return queue;
    }
}
