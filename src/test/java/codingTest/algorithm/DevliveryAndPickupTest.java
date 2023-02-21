package codingTest.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Slf4j
public class DevliveryAndPickupTest {
  private int cap;
  private int[] deliveries;
  private int[] pickups;
  private long answer;
  boolean endDeliver = false;
  boolean endPickup = false;

  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    this.cap = cap;
    this.deliveries = deliveries;
    this.pickups = pickups;

    goStart();
    return answer * 2;
  }

  @Test
  void test1() {
    long l = solution2(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{1, 0, 2, 0, 1});
    log.info("result : {}", l);
  }

  private void goStart() {
    boolean end = true;
    while (end) {
      int deliverLength = calLength(deliveries, "deliver");
      int pickupLength = calLength(pickups, "pickup");
      answer += Math.max(deliverLength, pickupLength);
      if (endDeliver && endPickup)
        end = false;
    }
  }

  private int calLength(int[] targetArray, String type) {
    int tempCap = cap;
    int tempLastPoint = 0;

    for (int i = targetArray.length - 1; i >= 0; i--) {
      int delTemp = targetArray[i];
      if (targetArray[i] != 0)
        tempLastPoint = Math.max(tempLastPoint, i + 1);
      targetArray[i] = calMinus(delTemp, tempCap);
      tempCap = calMinus(tempCap, delTemp);
      if (tempCap == 0)
        return tempLastPoint;
      if (i == 0) {
        if (type.equals("deliver"))
          endDeliver = true;
        else
          endPickup = true;

        return tempLastPoint;
      }

    }
    return 9999999;
  }

  private int calMinus(int target, int component) {
    if (target > component)
      return target - component;
    else
      return 0;
  }



  private long solution2(int cap, int n, int[] deliveries, int[] pickups){
    long answer = 0;
    int start = -1;
    int idx = -1;
    int give = 0;
    int get = 0;
    Integer[] test = new Integer[5];
    for(int i = n -1 ; i>=0; i--){
      if(deliveries[i] != 0 || pickups[i] != 0)  {
        int cnt =0;
        while(give < deliveries[i] || get < pickups[i]){
          ++cnt;
          give+=cap;
          get+=cap;
        }
        give -= deliveries[i];
        get -= pickups[i];
        answer = answer + (long) (i + 1) * cnt * 2;
      }
    }
    return answer;
  }
}
