package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class BinarySearchImmigration {

    private int n = 6;
    private int[] times = {7, 10};

    @Test
    void solution(){
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long start = times[0];  // 1분 부터
        long end = (long)times[times.length-1]*(long)n;     //times에는 심사대 마다 걸리는 시간이 걸려있으니 최대시간 = 가장오래걸리는시간 * 인원수


        long mid ;
        long sum = 0;
        while(start<=end) {
            mid=  (start+end)/2;
            sum = 0;
            for(int time : times) {
                sum+= mid/time;
            }

            if(sum>=n) {
                answer = Math.min(answer, mid);
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        log.info("result : {}", answer);
    }

}
