package codingTest.algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BinarySearch {

  private final static int[] arr = new int[250000001];

  @Test
  void test1(){
    for(int i = 0; i<arr.length; i++){
      arr[i] = i;
    }
    int i = binarySearch1(230000000, 0, 250000000);
    log.info("test : {}", i);

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
