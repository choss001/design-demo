package codingTest.algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class _217_1 {
    int board[][] = {
            {2, 5, 1, 6, 1, 4, 1},
            {6, 1, 1, 2, 2, 9, 3},
            {7, 2, 3, 2, 1, 3, 1},
            {1, 1, 3, 1, 7, 1, 2},
            {4, 1, 2, 3, 4, 1, 3},
            {3, 3, 1, 2, 3, 4, 1},
            {1, 5, 2, 9, 4, 7, 0}
    };
    int[][] cache = new int[7][7];
    int n = 7;

    @Test
    void test1() {
        int b = jump1(0, 0);
        log.info("result : {}", b);

    }

    private int jump2(int y, int x) {
        return 0;
    }

    private int jump1(int y, int x) {
        cacheSet();
        if (y >= n || x >= n) return 1;
        if (y == n - 1 && x == n - 1) return 0;
        int ret = cache[y][x];
        if(ret != -1) return ret;
        int jumpSize = board[y][x];
        return cache[y][x] = (jump1(y + jumpSize, x)) | (jump1(y, x + jumpSize));
    }
    private void cacheSet(){
        for(int i =0; i < cache[0].length; i++){
            for(int j = 0; j < cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
    }
}
