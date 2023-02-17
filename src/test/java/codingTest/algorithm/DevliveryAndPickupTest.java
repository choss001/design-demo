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
        return answer * 2;
    }
    private void goStart(){
        boolean end = true;
        while(end){
            int deliverLength = calLength(deliveries, "deliver");
            int pickupLength = calLength(pickups, "pickup");
            answer += Math.max(deliverLength, pickupLength);
            if(endDeliver && endPickup)
                end = false;
        }
    }
    
    private int calLength(int[] targetArray, String type){
        int tempCap = cap;
        int tempLastPoint = 0;

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
}
