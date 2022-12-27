package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class TravelPathTest_2 {

    private static final String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

    private static List<List<Integer>> answerIntegerList = new ArrayList<>();
    private static List<List<String>> answerStringList = new ArrayList<>();

    @Test
    void test1() {
        recursive(tickets);
//        for (List<Integer> temp : answerIntegerList)
//            System.out.println(temp);

        convertString(tickets);
        for (List<String> temp : answerStringList)
            System.out.println(temp);
        sortAndRemove();

        for (List<String> temp : answerStringList)
            System.out.println("result : " + temp);

    }

    private void recursive(String[][] tickets) {
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> integerList = queue.poll();
            if (integerList.size() == tickets.length) {
                answerIntegerList.add(integerList);
                continue;
            }

            Map<Integer, Integer> tempCheck = new HashMap<>();
            for (int i = 0; i < integerList.size(); i++) {
                tempCheck.put(integerList.get(i), 1);
            }
            for (int i = 0; i < tickets.length; i++) {
                if (tempCheck.getOrDefault(i, 0) == 0) {
                    if (tickets[i][0].equals(tickets[integerList.get(integerList.size() - 1)][1])) {
                        List<Integer> newIntegerList = new ArrayList<>(integerList);
                        newIntegerList.add(i);
                        queue.add(newIntegerList);
                    }
                }
            }
        }
    }

    private void convertString(String[][] tickets) {
        for (int i = 0; i < answerIntegerList.size(); i++) {
            List<String> tempStringList = new ArrayList<>();
            for (int j = 0; j < answerIntegerList.get(0).size(); j++) {
                tempStringList.add(tickets[answerIntegerList.get(i).get(j)][0]);
                if (j == answerIntegerList.get(0).size() - 1)
                    tempStringList.add(tickets[answerIntegerList.get(i).get(j)][1]);
            }
            answerStringList.add(tempStringList);
        }
    }

    private void sortAndRemove() {
        while (answerStringList.size() != 1) {
            for (int i = 0; i < answerStringList.get(0).size(); i++) {
                if (answerStringList.get(0).get(i).charAt(0) <
                        answerStringList.get(1).get(i).charAt(0)) {
                    answerStringList.remove(1);
                    break;
                } else if (answerStringList.get(0).get(i).charAt(0) >
                        answerStringList.get(1).get(i).charAt(0)) {
                    answerStringList.remove(0);
                    break;
                }

                if (answerStringList.get(0).get(i).charAt(1) <
                        answerStringList.get(1).get(i).charAt(1)) {
                    answerStringList.remove(1);
                    break;
                } else if (answerStringList.get(0).get(i).charAt(1) >
                        answerStringList.get(1).get(i).charAt(1)) {
                    answerStringList.remove(0);
                    break;

                }

                if (answerStringList.get(0).get(i).charAt(2) <
                        answerStringList.get(1).get(i).charAt(2)) {
                    answerStringList.remove(1);
                    break;
                } else if (answerStringList.get(0).get(i).charAt(2) >
                        answerStringList.get(1).get(i).charAt(2)) {
                    answerStringList.remove(0);
                    break;

                }

            }
        }
    }
}
