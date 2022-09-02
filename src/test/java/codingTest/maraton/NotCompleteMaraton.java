package codingTest.maraton;

import java.util.Arrays;

public class NotCompleteMaraton {

  public String solution(String[] participant, String[] completion) {
    String answer = "";

    Arrays.sort(completion);
    Arrays.sort(participant);

    int i =0;
    for (; i < completion.length; i++)
      if(!participant[i].equals(completion[i]))
        return participant[i];

    return participant[i];
  }

  public static void main(String[] args) {
    String[] part = {"leo", "kiki", "eden"};
    String[] comp = {"eden", "kiki"};
    NotCompleteMaraton ncm = new NotCompleteMaraton();
    System.out.println(ncm.solution(part, comp));

  }
}
