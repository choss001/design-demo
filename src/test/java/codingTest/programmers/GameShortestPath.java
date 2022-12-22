package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class GameShortestPath {

    //11
    int[][] input = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    //-1
    int[][] input_1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    @Test
    void test1() {
        log.info("restult : {}", solution(input));
    }

    public int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];

            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1)
                    continue;

                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }

        }


    }


    //my solution
    // 0 = y, 1 = x
    int[] y = {0, -1, 0, 1};
    int[] x = {1, 0, -1, 0};
    int answer = 0;

    private Queue<Integer[]> queue = new LinkedList();


    @Test
    void solution() {
        int[][] maps = input_1;
        System.out.println("test");
        move(maps);
        log.info("result : {}", answer);
    }

    private void move(int[][] maps) {
        queue.add(new Integer[]{0, 0, 1});
        while (queue.size() != 0) {
            Integer[] value = queue.poll();
            int dy = value[0];
            int dx = value[1];
            int count = value[2];
            if (dy == maps.length - 1 && dx == maps[0].length - 1) {
                answer = count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                if (dy + y[i] >= maps.length || dx + x[i] >= maps[0].length ||
                        dy + y[i] < 0 || dx + x[i] < 0) {
                    continue;
                }
                if (maps[dy + y[i]][dx + x[i]] == 1) {
                    queue.add(new Integer[]{dy + y[i], dx + x[i], count + 1});
                    maps[dy + y[i]][dx + x[i]] = count+1;
                }
            }
        }
    }
}
