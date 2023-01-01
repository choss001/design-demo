package codingTest.programmers;

import org.junit.jupiter.api.Test;

public class TravelPathtest_4 {

    private String answerStr = "";
    private boolean[] used;
    private String[][] tickets;

    @Test
    void test(){

    }

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        this.tickets = tickets;
        String[] answer = {};
        recursive();
        return answer;
    }
    private void recursive(){
        for(int i =0; i < tickets.length; i++){
        }
    }
}
