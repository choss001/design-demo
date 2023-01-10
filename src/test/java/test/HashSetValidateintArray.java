package test;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

@Slf4j
public class HashSetValidateintArray {

    @Test
    void test(){
        HashSet<int[]> testSet = new HashSet<>();
        testSet.add(new int[]{1});
        testSet.add(new int[]{2});
        testSet.add(new int[]{1});

        log.info("result : {}", testSet);

    }
}
