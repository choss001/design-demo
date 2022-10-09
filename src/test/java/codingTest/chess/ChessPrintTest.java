package codingTest.chess;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class ChessPrintTest {

  private static final String[][] CHESS_ALREADY = {
      {"W","B","W","B","W","B","W","B"},
      {"B","W","B","W","B","W","B","W"},
      {"W","B","W","B","W","B","W","B"},
      {"B","W","B","B","B","W","B","W"},
      {"W","B","W","B","W","B","W","B"},
      {"B","W","B","W","B","W","B","W"},
      {"W","B","W","B","W","B","W","B"},
      {"B","W","B","W","B","W","B","W"},
  };

//  private static final String[][] CHESS_ALREADY = {
//      {"B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B", "W"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B", "W"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B", "W"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B", "W"},
//      {"B", "B", "B", "B", "B", "B", "B", "B", "B", "W", "B", "W", "B"},
//      {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "B", "W", "B"},
//      {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "B", "W", "B"}
//  };

  private int count = 65;

  @Test
  void test1() {
    String[][] cutChess = new String[8][8];

    //행
    for (int i = 0; i < CHESS_ALREADY.length - 7; i++) {
      for (int k = 0; k < CHESS_ALREADY[0].length - 7; k++) {
        for (int j = 0; j < 8; j++) {
          //열
          for (int l = 0; l < 8; l++) {
//            System.out.println("l +k: " +(l + k));
            cutChess[j][l] = CHESS_ALREADY[i + j][k + l];
            if (j == 7 && l == 7) {
              System.out.println("i +" + i + ", j +" + j + ", k + " + k + ", l +" + l);
              Arrays.stream(cutChess)
                  .forEach(item -> {
                    Arrays.stream(item)
                        .forEach(System.out::print);
                    System.out.println();
                  });
              System.out.println();
              int tempCount = countColor(cutChess);
              count = Math.min(count, tempCount);
              System.out.println("count : " + count);

            }
          }
        }
      }


    }
  }

  private int countColor(String[][] cutChess) {
    int tempCount = 0;
    Queue<String> queue = new LinkedList<>();
    IntStream.range(0,4).forEach(k -> {
      IntStream.range(0,8)
          .forEach(i -> {
            String value = i % 2 == 0 ? "B" : "W";
            queue.add(value);
          });
      IntStream.range(0,8)
          .forEach(i -> {
            String value = i % 2 == 0 ? "W" : "B";
            queue.add(value);
          });
    });
    for (int i = 0; i < cutChess.length; i++) {
      for (int j = 0; j < cutChess[0].length; j++) {
        if (!cutChess[i][j].equals(queue.peek())){
          System.out.println("old : " + cutChess[i][j] + ", new : " +queue.peek()+", i : " + i + ", j : "+ j);
          tempCount++;
        }
        queue.poll();
      }
    }
    return Math.min(tempCount, 64-tempCount);
  }

  @Test
  void regex1() {
    String test = "Abcd 3dkiwkd sdjfk    ";
    String s = test.replaceAll(" (\\w)", " wow$0wow");
    System.out.printf("test %s", s);
  }

  @Test
  void regex2() {
    String line = "This order was placed for QT3000! OK?";
//    String pattern = "(.*)(\\d+)(.*)";
    String pattern = "(.*)";

    Pattern r = Pattern.compile(pattern);

    Matcher m = r.matcher(line);

    if(m.find()){
      System.out.printf("Found value : %s%n", m.group(0));
      System.out.printf("Found value : %s%n", m.group(1));
//      System.out.printf("Found value : %s%n", m.group(2));
//      System.out.printf("Found value : %s%n", m.group(3));
      System.out.printf("Found value : %s%n", m.groupCount());
    }else
      System.out.println("NO MATCH");
  }
}
