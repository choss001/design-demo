package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.lang.Math.*;

@Slf4j
public class _226_3 {

    private int n = 5;
    private int[][] cache = new int[100][100];
    private static int[][] triangle = {
            {6, 0, 0, 0, 0},
            {1, 2, 0, 0, 0},
            {3, 7, 4, 0, 0},
            {9, 4, 1, 7, 0},
            {2, 7, 5, 9, 4}
    };

    @Test
    void test1() {
        initialCache();
        log.info("result : {}", path1(0, 0));

    }
    private void initialCache(){
        for(int i =0; i< 100; i++)
            for (int j = 0; j < 100; j++)
                    cache[i][j] = -1;
    }

    private int path1(int y, int x) {
        if (y == n - 1) return triangle[y][x];
        //메모이제이션
        if (cache[y][x] != -1) return cache[y][x];
        return cache[y][x] = max(path1(y+1, x), path1(y+1, x+1))
                + triangle[y][x];
    }


}
