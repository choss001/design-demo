package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class SelectSortTest {

  int[] A = {1, 2, 5, 3, 10, 20, 13, 7, 4};
  @Test
  void test1(){
//    selectSort();
//    insertSort();
//    log.info("result : {}", A);
    List<Integer> list = IntStream.range(0, 7)
        .boxed()
        .collect(Collectors.toList());

    recursiveAlgorithms(7, new ArrayList<Integer>(), 4);

  }

  void selectSort() {
    for(int i = 0; i< A.length; i++){
      int minIndex =i;
      for(int j = i+1; j < A.length; j++){
        if(A[minIndex] > A[j])
          minIndex = j;
      }
      int temp = A[i];
      A[i] = A[minIndex];
      A[minIndex] = temp;
    }
  }
  void insertSort(){
    for(int i = 0; i< A.length; i++ ){
      int j = i;
      while( j> 0 && A[j-1] > A[j]){
        int temp = A[j-1];
        A[j-1] = A[j];
        A[j] = temp;
        --j;
      }
    }
  }

  void recursiveAlgorithms(int n, List<Integer> picked, int toPick){
    if(toPick == 0){
      log.info("picked : {} ",picked);
      return;
    }
    int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() -1) +1;
    for(int next = smallest; next < n; next++){
      picked.add(next);
      recursiveAlgorithms(n, new ArrayList<Integer>(picked), toPick -1);
      picked.remove(picked.size() -1);
    }
  }
}
