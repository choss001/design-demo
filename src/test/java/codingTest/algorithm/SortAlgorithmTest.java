package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SortAlgorithmTest {

    void bubble(int arr[], int arrSize){
        int i, j, temp;
        for(i =0; i < arrSize - 1; i++){
            for(j = 0; j < arrSize - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    void bubbleSort(){
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
//        bubble(arr, arrSize);
        selection(arr, arrSize);
        log.info("resrult : {}", arr);
    }

    void selection(int[] arr, int arrSize){
        int minInd;
        for (int i = 0; i < arrSize; i++) {
            minInd = findMin(arr, i, arrSize - 1);
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }
    int findMin(int[] arr, int start, int end) {
        if (end <= 0 || start < 0)
            return 0;

        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minInd] > arr[i])
                minInd = i;
        }
        return minInd;
    }
}
