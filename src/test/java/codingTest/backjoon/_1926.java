package codingTest.backjoon;

import org.junit.jupiter.api.Test;

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

    int[] x = {1, 0, -1, 0};
    int[] y = {0, -1, 0, 1};


    //est
    @Test
    void test1(){

    }

    private void recursive(int inheritedY, int inheritedX){
        int curX = 0;
        int curY = 0;
        for(int i = 0; i < 4; i++){
            curX = x[i];
            curY = y[i];
        }

        for(int i =0; i< input.length; i++ ){
            for (int j = 0; j < input[0].length; j++) {
                if(input[curY][curX] == 1 && !cache[curY][curX] ){
                    recursive(curX, curY);
                }
            }
        }
    }

}
