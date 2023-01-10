package test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PassByValueArrayTest {

    List<int[][]> listArray = new ArrayList<>();
    int[][] value = {
            {1, 0, 1},
            {0, 1, 0}
    };

    @Test
    void test1() {
        listArray.add(value);
        printArray(listArray.get(0));
        comtamination(listArray.get(0));
        printArray(listArray.get(0));

        String create = "create";
        System.out.println();
        System.out.println(create);
        modifyValueStr(create);
        System.out.println(create);

        listArray.add(value);
        listArray.add(value);
        listArray.add(value);
        listArray.add(value);
        log.info("size : {}", listArray.size());
    }

    private void comtamination(int[][] value) {
        value[0][0] = 0;
    }
    private void modifyValueStr(String str){
        str = "modify";
    }

    private void printArray(int[][] value) {
        System.out.println();
        for (int i = 0; i < value.length; i++) {
            System.out.println();
            for (int j = 0; j < value[0].length; j++) {
                System.out.printf("%d ",value[i][j]);
            }
        }
    }
}
