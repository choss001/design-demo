package codingTest.algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
public class BinarySearch {

  private final static int[] arr = new int[250000001];
  private int[] inputArray = {1,200,3,2,50,60,70,26,34,60};

  @Test
  void test1(){
//    for(int i = 0; i<arr.length; i++){
//      arr[i] = i;
//    }
//    int i = binarySearch1(230000000, 0, 250000000);
//    log.info("test : {}", i);
    Arrays.sort(inputArray);
    log.info("result : {}", inputArray);
    log.info("binary search : {}", binarySearch2(inputArray, 26));

    boolean why = false;
    testBollean(why);
    log.info("result : {}", why);

  }
  int binarySearch2(int[] inputArray, int target){
    int first = 0;
    int last = inputArray.length -1;
    int mid = inputArray.length/2;
    boolean loof = true;

    while(loof){
      if(inputArray[mid] > target){
        last = mid;
        mid = (first + last)/2;
      }else if(inputArray[mid] < target){
        first = mid;
        mid = (last + mid)/2;
      }else{
        return mid;
      }
      if( first >= mid)
        loof = false;
    }
    return -1;
  }

  private void testBollean(boolean why){
    why = true;
  }

  int binarySearch1(int key, int low, int high) {
    int mid;

    if(low <= high) {
      mid = (low + high) / 2;

      if(key == arr[mid]) { // 탐색 성공
        return mid;
      } else if(key < arr[mid]) {
        // 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색
        return binarySearch1(key ,low, mid-1);
      } else {
        // 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색
        return binarySearch1(key, mid+1, high);
      }
    }

    return -1; // 탐색 실패
  }

}
