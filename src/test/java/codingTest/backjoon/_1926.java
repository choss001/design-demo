package codingTest.backjoon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _1926 {

    //    6 5
//            1 1 0 1 1
//            0 1 1 0 0
//            0 0 0 0 0
//            1 0 1 1 1
//            0 0 1 1 1
//            0 0 1 1 1
    int[][] input = {
            {1, 1, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
    };
    boolean[][] cache = new boolean[6][5];
    private List<List<int[]>> listArray = new ArrayList<>();

    int[] x = {1, 0, -1, 0};
    int[] y = {0, -1, 0, 1};


    //test
    @Test
    void test1() {
        exploration();
        for (int i = 0; i < listArray.size(); i++) {
            for (int j = 0; j < listArray.get(i).size(); j++) {
                System.out.printf("\n y : %d, x : %d", listArray.get(i).get(j)[0], listArray.get(i).get(j)[1]);
            }
            System.out.println();
        }

    }

    private void exploration() {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 1 && !cache[i][j]) {
                    List<int[]> tempArrayList = new ArrayList<>();
                    findBlock(i, j, tempArrayList);
                    listArray.add(tempArrayList);
                }
            }
        }
    }

    //테스트입니다.
    private void findBlock(int passedY, int passedX, List<int[]> tempArrayList) {
        int curX = 0;
        int curY = 0;
        tempArrayList.add(new int[]{passedY, passedX});
        cache[passedY][passedX] = true;

        for (int i = 0; i < 4; i++) {
            curX = x[i];
            curY = y[i];

            if ((curY + passedY) < 0 || (curY + passedY) >= input.length ||
                    (curX + passedX) < 0 || (curX + passedX) >= input[0].length)
                continue;

            if (input[curY + passedY][curX + passedX] == 1 && !cache[curY + passedY][curX + passedX]) {
                findBlock(passedY + curY, passedX + curX, tempArrayList);
            }

        }
    }
}
