package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
public class _226 {

    private static int[][] triangle = {
            {6, 0, 0, 0, 0},
            {1, 2, 0, 0, 0},
            {3, 7, 4, 0, 0},
            {9, 4, 1, 7, 0},
            {2, 7, 5, 9, 4}
    };
    private int y = 0;
    private int x = 0;
    private int answer = 0;
    private int[] dy = {1, 1};
    private int[] dx = {0, 1};

    @Test
    void test1() {
        solution(triangle, x, y);
        log.info("last answer!!!! : {}", answer);
    }

    private int solution(int[][] triangle, int x, int y) {
        int[][] move = new int[5][5];
        move[0][0] = 1;
        recursive(0, 0, 6, move);

        return 0;
    }

    private void recursive(int x, int y, int answer, int[][] move) {

        if (y == triangle.length -1) {
            this.answer = Math.max(answer, this.answer);
            for(int i =0; i < 5; i++){
                for(int j =0; j < 5; j ++){
                    System.out.print(move[i][j]);
                }
                System.out.println();
            }
            System.out.println("result : "+ answer);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int afterX = x + dx[i];
            int afterY = y + dy[i];
            if(afterX > triangle[0].length -1 || afterY > triangle.length -1)
                continue;

            move[afterY][afterX] = 1;
            recursive(afterX, afterY, answer + triangle[afterY][afterX], move);
            move[afterY][afterX] = 0;
        }
    }

}
