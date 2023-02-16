package codingTest.algorithm;

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
        return answer;
    }
    private void goStart(){
        boolean end = true;
        while(end){
            int deliverLength = calLength(deliveries, "deliver");
            int pickupLength = calLength(pickups, "pickup");
            answer += Math.max(deliverLength, pickupLength) * 2;
            if(endDeliver && endPickup)
                end = false;
        }
    }
    
    private int calLength(int[] targetArray, String type){
        int tempCap = cap;
        int tempLastPoint = 0;
//      if(type.equals("deliver") && endDeliver)
//          return 0;
//      else if(type.equals("pickup") && endPickup)
//          return 0;
        
        for(int i =targetArray.length - 1; i >= 0; i--){
            int delTemp = targetArray[i];
            if(targetArray[i] != 0)
                tempLastPoint = Math.max(tempLastPoint, i + 1);
            targetArray[i] = calMinus(delTemp, tempCap);
            tempCap = calMinus(tempCap, delTemp);
            if(tempCap ==0)
                return tempLastPoint;
            if(i == 0){
                if(type.equals("deliver"))
                    endDeliver = true;
                else
                    endPickup  = true;
                    
                return tempLastPoint;
            }
            
        }
        return 9999999;
    }
    
    private int calMinus(int target, int component){
        if(target > component)
            return target-component;
        else
            return 0;
    }

    public static long solution2(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int box = cap;
        int rbox = cap;
        int max = 0;
        int gostop = 0;
        int backstop = 0;
        while (true) {
            for (int i = n - 1; i > -1; i--) {
                if (deliveries[i] > 0 && max == 0) {
                    max = i + 1;
                    break;
                } else if (pickups[i] > 0 && max == 0) {
                    max = i + 1;
                    break;
                }
            }
            for (int i = n - 1; i > -1; i--) {
                if (box > 0 && deliveries[i] > 0) {
                    if (deliveries[i] > box) {
                        deliveries[i] -= box;
                        box = 0;
                        gostop = i + 1;
                    } else if (deliveries[i] < box) {
                        box -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        gostop = i;
                        box = 0;
                        deliveries[i] = 0;
                    }
                }
                if (rbox > 0 && pickups[i] > 0) {
                    if (pickups[i] > rbox) {
                        pickups[i] -= rbox;
                        rbox = 0;
                        backstop = i + 1;
                    } else if (pickups[i] < rbox) {
                        rbox -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        backstop = i;
                        rbox = 0;
                        pickups[i] = 0;
                    }
                }
                if (box == 0 && rbox == 0) {
                    break;
                }
            }
            if (box == cap && rbox == cap) {
                break;
            } else {
                answer += max;
                n = gostop > backstop ? gostop : backstop;
                box = cap;
                rbox = cap;
                max = 0;
                gostop = 0;
                backstop = 0;
            }
        }
        return answer * 2;
    }

}
