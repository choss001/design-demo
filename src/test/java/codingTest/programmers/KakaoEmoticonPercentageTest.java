package codingTest.programmers;

public class KakaoEmoticonPercentageTest {
    private int[] answerArray = new int[2];
    private int[] percents = new int[4];
    private int[][] users;
    private int[] emoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        setPercents();
        this.users = users;
        this.emoticons = emoticons;

        int[] answer = {};
        return answer;
    }
    private void recursive(int nextTarget, int[] tempAnswer){
        int localPercents;
        for(int i = 0; i < 4; i ++){
            localPercents = percents[i];
        }
        recursive(nextTarget + 1, tempAnswer);
    }

    private void calcurate(int localPercents, int nextTarget, int[] tempAnswer){
        if(users[nextTarget][0] <= localPercents){
            for(int i =0; i < emoticons.length; i++){

            }
        }
    }

    private void setPercents(){
        percents[0] = 40;
        percents[1] = 30;
        percents[2] = 20;
        percents[3] = 10;
    }
}
