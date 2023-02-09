package codingTest.algorithm;

public class DevliveryAndPickupTest {
    private int cap;
    private int[] deliveries;
    private int[] pickups;
    private long answer;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        this.cap = cap;
        this.deliveries = deliveries;
        this.pickups = pickups;

        goStart();
        return answer;
    }

    private void goStart() {
        boolean end = true;
        while (end) {
            int deliverLength = calLength(deliveries);
            int pickupLength = calLength(pickups);
            answer += Math.max(deliverLength, pickupLength) * 2;
            end = isNotFinish();
        }
    }

    private boolean isNotFinish() {
        for (int i = 0; i < deliveries.length; i++) {
            if (0 < deliveries[i] || 0 < pickups[i])
                return true;
        }
        return false;
    }

    private int calLength(int[] targetArray) {
        int tempCap = cap;
        for (int i = 0; i < targetArray.length; i++) {
            int delTemp = targetArray[i];
            targetArray[i] = calMinus(delTemp, tempCap);
            tempCap = calMinus(tempCap, delTemp);
            if (tempCap == 0)
                return i + 1;
        }
        System.out.println("why : " + tempCap);
        return 9999999;
    }

    private int calMinus(int target, int component) {
        if (target > component)
            return target - component;
        else
            return 0;
    }
}
