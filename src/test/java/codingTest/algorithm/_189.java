package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class _189 {
    String input = "xbwwb";
    String output = "xwbbw";

    String input_2 = "xbwxwbbwb";
    String output_2 = "xxbwwbbbw";
    private final static int MAX_SIZE = 4;
    private char[][] decompressed = new char[MAX_SIZE][MAX_SIZE];

//  1100
//  1100
//  0111
//  1011

    //  1011
//  0111
//  1100
//  1100
    @Test
    void test1() {
//        String[] headArray = input.split("");
//        Iterable<String> head = Arrays.asList(headArray);
//        String reverse = reverse(head.iterator());
//        log.info("result : {}", reverse);
        Character[] characterArray = input_2.chars().mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        Iterable<Character> characters = Arrays.asList(characterArray);

        decompress(characters.iterator(), 0, 0, MAX_SIZE);
//        log.info("result : {}", decompressed);
//        log.info("result : {}", decompressed);
        log.info("result");
    }
    private String reverse(Iterator<String> it){
        String head = it.next();
        if(head.equals("b")  || head.equals("w"))
            return head;
        String upperLeft = reverse(it);
        String upperRight = reverse(it);
        String lowerLeft = reverse(it);
        String lowerRight = reverse(it);
        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }

    private void decompress(Iterator<Character> it, int y, int x, int size) {
        Character head = it.next();

        if (head.equals('b') || head.equals('w')) {
            for (int dy = 0; dy < size; dy++) {
                for (int dx = 0; dx < size; dx++) {
                    decompressed[y + dy][x + dx] = head;
                }
            }
        } else {
            int half = size / 2;
            decompress(it, y, x, half);
            decompress(it, y, x + half, half);
            decompress(it, y + half, x, half);
            decompress(it, y + half, x + half, half);
        }

    }

}
