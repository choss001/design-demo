package codingTest.algorithm;

public class DevliveryAndPickupTest {
    private int cap;
    private int[] deliveries;
    private int[] pickups;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        this.cap = cap;
        this.deliveries = deliveries;
        this.pickups = pickups;

        long answer = -1;

        //주석
        return answer;
    }
    private void goStart(){
        boolean end = false;
        int deliver = cap;
        int goLength = 0;
        while(end){
            for(int i =0; i < deliveries.length; i++){
                int delTemp = deliveries[i];
                deliveries[i] = calMinus(delTemp, deliver);
                deliver = calMinus(deliver, delTemp);
                if(deliver ==0){
                    goLength = i+1;
                    break;
                }

            }

        }
    }
//  private int calLength(int[] targetArray){
//      for(int i =0; i < deliveries.length; i++){
//          int delTemp = targetArray[i];
//          targetArray[i] = calMinus(delTemp, deliver);
//          deliver = calMinus(deliver, delTemp);
//          if(deliver ==0){
//              goLength = i+1;
//              break;
//          }
//      }
//  }

    private int calMinus(int target, int component){
        if(target > component)
            return target-component;
        else
            return 0;
    }
}
