package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class _197 {
    private String input = "7 1 5 9 6 7 3";
    private int size = 7;
    //    int[] h = {7, 1, 5, 9, 6, 7, 3};
    int[] h = {1, 4, 4, 4, 4, 1, 1};

    @Test
    void test1() {
        int solve = solve(0, 6);
        log.info("restult : {}", solve);
    }

    private int solve(int left, int right) {
        if (left == right) return h[left];
        int mid = (left + right) / 2;
        int ret = Math.max(solve(left, mid), solve(mid + 1, right));
        int lo = mid, hi = mid + 1;
        int height = Math.min(h[lo], h[hi]);
        ret = Math.max(ret, height * 2);
        while (left < lo || hi < right) {
            if (hi < right && (lo == left || h[lo - 1] < h[hi + 1])) {
                ++hi;
                height = Math.min(height, h[hi]);
            } else {
                --lo;
                height = Math.min(height, h[lo]);
            }
            ret = Math.max(ret, height * (hi - lo + 1));
        }
        return ret;
    }
}
