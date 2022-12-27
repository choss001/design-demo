package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

@Slf4j
public class TravelPathTest_3 {
    boolean[] visited;
    ArrayList<String> allRoute;

    private static final String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

    @Test
    void test1(){
        String[] solution = solution(tickets);
        log.info("result : {}", solution);
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allRoute.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }

    }
}