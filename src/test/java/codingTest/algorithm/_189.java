package codingTest.algorithm;

import org.junit.jupiter.api.Test;

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


    }
    private String reverseTree(String input){
        String[] inputArray = input.split("");
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i].equals("b") || inputArray[i].equals("w")){
                return inputArray[i];
            }else{
                String LU = reverseTree();
            }
        }
        return null;
    }
}
