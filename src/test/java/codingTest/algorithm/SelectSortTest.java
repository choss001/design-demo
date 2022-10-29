package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.*;

@Slf4j
public class SelectSortTest {
    private List<Integer> ret = new ArrayList<>();
    private int maxSum = 0;


    int[] A = {1, 2, 5, 3, 10, 20, 13, 7, 4};

    @Test
    void test1() {
//    selectSort();
//    insertSort();
//    log.info("result : {}", A);
        List<Integer> list = IntStream.range(0, 7)
                .boxed()
                .collect(Collectors.toList());

        recursiveAlgorithms(7, new ArrayList<Integer>(), 4);

    }

    void selectSort() {
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[minIndex] > A[j])
                    minIndex = j;
            }
            int temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;
        }
    }

    void insertSort() {
        for (int i = 0; i < A.length; i++) {
            int j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                int temp = A[j - 1];
                A[j - 1] = A[j];
                A[j] = temp;
                --j;
            }
        }
    }
    @Test
            void MaxSum() {
        int[] input = {-7, 4, -3, 6, 3, -8, 3, 4};
        inefficient(input);
        log.info("return : {}", ret);
        int fastMaxSum = fastMaxSum(input, 0, 7);
        log.info("fastMaxSum : {}", fastMaxSum);

        int fastestMaxSum = fastestMaxSum(input);
        log.info("fastestMaxSum : {}", fastestMaxSum);

    }

    private void inefficient(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int tempSum = input[i];
            for (int j = i + 1; j < input.length; j++) {
                tempSum += input[j];
                if (tempSum > maxSum) {
                    ret.clear();
                    maxSum = tempSum;
                    for (int k = i; k <= j; k++) {
                        ret.add(input[k]);
                    }
                }
            }
        }
    }

    // 시간복잡도 O(nlogn)
    private int fastMaxSum(int[] A, int lo, int hi) {
        //기저 사례: 구간의 길이가 1일 경우
        if (lo == hi) return A[lo];
        //배열을 A[lo..mid], A[mid+1..hi]의 두 조각으로 나눈다.
        int mid = (lo + hi) / 2;
        /** 두 부분에 모두 걸쳐 있는 최대 합 구간을 찾는다. 이 구간은
         * A[i..mid]와 A[mid+1..j] 형태를 갖는 구간의 합으로 이루어진다.
         * A[i..mid] 형태를 갖는 최대 구간을 찾는다.
         */

        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= lo; --i) {
            sum += A[i];
            left = max(left, sum);
        }
        // A[mid+1..j] 형태를 갖는 최대 구간을 찾는다.
        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += A[j];
            right = max(right, sum);
        }
        // 최대 구간이 두 조각 중 하나에만 속해 있는 경우의 답을 재귀 호출로 찾는다.
        int single = max(fastMaxSum(A, lo, mid),
                fastMaxSum(A, mid + 1, hi));
        // 두 경우는 최대치를 반환한다.
        return max(left + right, single);
    }

    private int fastestMaxSum(int[] A) {
        int N = A.length, retInt = Integer.MIN_VALUE, psum = 0;
        for (int i = 0; i < N; i++) {
            psum = max(psum, 0) + A[i];
            retInt = max(psum, retInt);
        }
        return retInt;
    }

    void recursiveAlgorithms(int n, List<Integer> picked, int toPick) {
        if (toPick == 0) {
            log.info("picked : {} ", picked);
            return;
        }
        int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;
        for (int next = smallest; next < n; next++) {
            picked.add(next);
            recursiveAlgorithms(n, new ArrayList<Integer>(picked), toPick - 1);
            picked.remove(picked.size() - 1);
        }
    }

}
