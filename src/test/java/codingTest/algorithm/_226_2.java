package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _226_2 {
    private int n = 5;
    private int[][][] cache = new int[100][100][10000];
    private int sum =0;
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
        log.info("result : {}", path1(0, 0, 0));

    }
    private void initialCache(){
        for(int i =0; i< 100; i++)
            for (int j = 0; j < 100; j++)
                for (int k = 0; k < 10000; k++)
                    cache[i][j][k] = -1;
    }

    private int path1(int y, int x, int sum) {
        if (y == n - 1) return sum + triangle[y][x];
        //메모이제이션
        if (cache[y][x][sum] != -1) return cache[y][x][sum];
        sum += triangle[y][x];
        return cache[y][x][sum] = Math.max(path1(y+1, x+1 ,sum), path1(y+1, x, sum));
    }
}
