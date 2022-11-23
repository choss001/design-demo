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
        String[] headArray = input_2.split("");
//        String[] headArray = input.split("");
        Iterable<String> head = Arrays.asList(headArray);
        String reverse = reverse(head.iterator());
        log.info("result : {}", reverse);
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
}
