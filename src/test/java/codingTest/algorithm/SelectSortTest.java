package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SelectSortTest {

  int[] A = {1, 2, 5, 3, 10, 20, 13, 7, 4};
  @Test
  void test1(){
//    selectSort();
    insertSort();
    log.info("result : {}", A);

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
}
