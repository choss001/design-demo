package codingTest.programmers;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class NetworkPracticeTest {
    private boolean[] temp;
    @Test
    void network(){
        log.info("result1 : {}", solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        log.info("result2 : {}", solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));

    }

    private int solution(int n, int[][] relationShip) {
        temp = new boolean[n];
        int answer = 0;
        for(int i =0; i < n; i++){
            answer++;
        }
        return answer;
    }
    private void dfs(int n,int i, int[][] relationShip){

        temp[i] = true;
        for (int j = 0; j < n; j++) {
            if (i != j && relationShip[i][j] == 1) {
                temp[i] = true;
            }
        }

    }
}
