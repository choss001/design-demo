package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _226 {

    private static int[][] triangle = {
            {6, 0, 0, 0, 0},
            {1, 2, 0, 0, 0},
            {3, 7, 4, 0, 0},
            {9, 4, 1, 7, 0},
            {2, 7, 5, 9, 4}
    };
    private int y = 4;
    private int x = 0;
    private int answer = 0;
    private int[] dy = {-1, 0};
    private int[] dx = {0, 1};

    @Test
    void test1() {
        solution(triangle, x, y);
    }

    private int solution(int[][] triangle, int x, int y) {
        recursive(0, 4, 6);
        log.info("result : {}", answer);
        return 0;
    }

    private void recursive(int x, int y, int answer) {
        if (y == 0) {
            this.answer = Math.max(answer, this.answer);
        }

        for (int i = 0; i < 2; i++) {
            int afterX = x + dx[i];
            int afterY = y + dy[i];

            if(afterX > triangle[0].length -1 )
                continue;

            if(afterY < 0)
                continue;

            recursive(afterX, afterY, answer + triangle[afterY][afterX]);
        }
    }

}
