package codingTest.chess;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


/**
 *  http://hg.openjdk.java.net/jdk7u/jdk7u6/jdk/file/8c2c5d63a17e/test/java/util/regex/TestCases.txt
 *  사이트 참고
 *
 */


public class ChessPrintTest {

  private static final String[][] CHESS_ALREADY = {
      {"W", "B", "W", "B", "W", "B", "W", "B"},
      {"B", "W", "B", "W", "B", "W", "B", "W"},
      {"W", "B", "W", "B", "W", "B", "W", "B"},
      {"B", "W", "B", "B", "B", "W", "B", "W"},
      {"W", "B", "W", "B", "W", "B", "W", "B"},
      {"B", "W", "B", "W", "B", "W", "B", "W"},
      {"W", "B", "W", "B", "W", "B", "W", "B"},
      {"B", "W", "B", "W", "B", "W", "B", "W"},
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
    IntStream.range(0, 4).forEach(k -> {
      IntStream.range(0, 8)
          .forEach(i -> {
            String value = i % 2 == 0 ? "B" : "W";
            queue.add(value);
          });
      IntStream.range(0, 8)
          .forEach(i -> {
            String value = i % 2 == 0 ? "W" : "B";
            queue.add(value);
          });
    });
    for (int i = 0; i < cutChess.length; i++) {
      for (int j = 0; j < cutChess[0].length; j++) {
        if (!cutChess[i][j].equals(queue.peek())) {
          System.out.println("old : " + cutChess[i][j] + ", new : " + queue.peek() + ", i : " + i + ", j : " + j);
          tempCount++;
        }
        queue.poll();
      }
    }
    return Math.min(tempCount, 64 - tempCount);
  }

  @Test
  void regex1() {
    String test = "Abcd 3dkiwkd sdjfk    ";
    String s = test.replaceAll(" (\\w)", " wow$0wow");
    System.out.printf("test %s", s);
  }

  @Test
  void regex2() {
//    String line = "This order was placed for QT3000! OK?";
//    String line = "########################### CancellationService ###########################";
    String line = "2022-10-05 23:56:58.103  INFO 7 --- [http-nio-8890-exec-92233] c.e.t.s.s.i.i.SktUserStatisticsService   : ########################### dbSubscription : JS045 ###########################";
//    String pattern = ".*?exec-(\\d+)].*#{2,}.+";
    String pattern = ".*exec-(\\d+)].*#{2,} dbSubscription :.*";
//    String pattern = "(.*)";

    Pattern r = Pattern.compile(pattern);

    Matcher m = r.matcher(line);
//    MatchResult m = r.matcher(line);

    if (m.find()) {
      System.out.printf("Found value group(0): %s, start : %d, end : %d %n", m.group(0), m.start(0), m.end(0));
      System.out.printf("Found value group(1): %s, start : %d, end : %d %n", m.group(1), m.start(1), m.end(1));
//      System.out.printf("Found value group(2): %s, start : %d, end : %d %n", m.group(2), m.start(2), m.end(2));
      System.out.printf("group Count : %s%n", m.groupCount());
      System.out.printf("just group() : %s%n", m.group());

    } else
      System.out.println("NO MATCH");

    System.out.printf("pattern matches test : %b", Pattern.matches(".s", "as"));
  }

  @Test
  void regex3() {
    System.out.printf("pattern matches test : %b%n", Pattern.matches("[amn]", "abcd"));
    System.out.printf("pattern matches test : %b%n", Pattern.matches("[amn]", "a"));
    System.out.printf("pattern matches test : %b%n", Pattern.matches("[amn]", "ammmm"));
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter regex pattern");
    Pattern pattern = Pattern.compile(sc.nextLine());
    System.out.println("Enter Text");
    Matcher matcher = pattern.matcher(sc.nextLine());
    boolean found = false;
    while (matcher.find()) {
      System.out.println("I found the text " + matcher.group() + " starting at index " +
          matcher.start() + " and ending at index " + matcher.end());
      found = true;
    }
    if (!found) {
      System.out.println("No match found");
    }
  }

  @Test
  void regexTest() {
    String s = "3people unFollowed me";
    Pattern pattern = Pattern.compile("\\b");
    Matcher matcher = pattern.matcher(s);


    StringBuilder builder = new StringBuilder(s.toLowerCase());
    boolean flag = true;

    while (matcher.find()) {
      if(flag){
        String targetStr = Character.toString(s.charAt(matcher.start()));

        if (Pattern.matches("\\w",
            Character
                .toString(s.charAt(
                    matcher.start())))) {
          builder.setCharAt(matcher.start(), targetStr.toUpperCase().charAt(0));
        }
        flag = false;
      }else
        flag = true;

    }
    System.out.println(builder.toString());

  }

  @Test
  void answer() {
    String s = "3people unFollowed me";
    String answer = "";
    String[] sp = s.toLowerCase().split("");
    boolean flag = true;

    for(String ss : sp) {
      answer += flag ? ss.toUpperCase() : ss;
      flag = ss.equals(" ") ? true : false;
    }
    System.out.println("answer :" + answer);

  }

  @Test
  void regex4() {
    String id = "...!@BaT#*..y.abcdefghijklm.";
    id = id.toLowerCase();
//    id = id.replaceAll("\\.+", "\\.");
    id = id.replaceAll("^(\\.)|(\\.)$|(\\.+)", "");
//    id = id.replaceAll("[\\.]$", "");
    System.out.println(id);

  }

  @Test
  void regex5(){
    String id = "aaabbbddsjjjjj";

    id = id.replaceAll(".*(.{5})", "$1");
    System.out.println(id);
  }
}
