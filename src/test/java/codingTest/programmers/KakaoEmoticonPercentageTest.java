package codingTest.programmers;

public class KakaoEmoticonPercentageTest {
    private int[] percentages = {40, 30, 20, 10};
    private int[][] users;
    private int[] emoticons;
    private int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        recursive(new ArrayList<>(), 0);

        return answer;
    }

    private void recursive(List<Integer> emoticonPer, int position){
        if(position == emoticons.length){
            calculateUser(emoticonPer);
            return;
        }

        for(int i =0; i < 4; i ++){
            emoticonPer.add(percentages[i]);
            recursive(emoticonPer, position +1);
            emoticonPer.remove(position);
        }
    }

    private void calculateUser(List<Integer> emoticonPer){
        int[] tempAnswer = new int[2];
        for(int i = 0; i < users.length; i++){
            int totalCost = 0;
            for(int j = 0; j < emoticonPer.size(); j++){
                int percent = emoticonPer.get(j);
                int beforePrice = emoticons[j];
                if(percent >= users[i][0]){
//                  System.out.println("result : "+ (beforePrice * (100 - percent))/100);
                    totalCost += (beforePrice * (100 - percent))/100;
                }
            }
            if(totalCost >= users[i][1]){
                tempAnswer[0] += 1;
                tempAnswer[1] += totalCost;
            }
        }
        comparison(tempAnswer);
    }

    private void comparison(int[] tempAnswer){
        if(tempAnswer[0] > answer[0]){
            answer[0] = tempAnswer[0];
            answer[1] = tempAnswer[1];
        }else if(tempAnswer[0] == answer[0]){
            if(tempAnswer[1] > answer[1]){
                answer[0] = tempAnswer[0];
                answer[1] = tempAnswer[1];
            }
        }
    }
}
