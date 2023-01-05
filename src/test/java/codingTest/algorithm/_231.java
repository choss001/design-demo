package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class _231 {

    int[] input = {1, 4, 3, 3, 7, 2, 99999, 1};
    List<Integer> answer = new ArrayList<>();
    boolean[] usedCheck;

    @Test
    void test1() {
        solution(input);
        answer.remove(0);
        log.info("result : {}", answer);
    }

    private int[] solution(int[] input) {
        usedCheck = new boolean[input.length];
        List<Integer> tempList = new ArrayList<>();
        tempList.add(-1);
        recursive(input, tempList);
        return null;
    }

    private void recursive(int[] input, List<Integer> tempList) {
        for (int i = 0; i < input.length; i++) {
            if (usedCheck[i] == false && tempList.get(tempList.size() - 1) < input[i]) {
                usedCheck[i] = true;
                tempList.add(input[i]);
                recursive(input, tempList);
                tempList.remove(tempList.size() - 1);
                usedCheck[i] = false;
            }
        }
        if (answer.isEmpty())
            answer.addAll(tempList);
        else {
            if (answer.size() < tempList.size()) {
                answer.clear();
                answer.addAll(tempList);
            }
        }
    }
}
