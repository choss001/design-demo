package codingTest.programmers;

public class ItemObjtainTest {
  private int[] y = {1, 0, -1, 0};
  private int[] x = {0, 1, 0, -1};
  private static int[][] allMap = new int[50][50];
  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    makeMap(rectangle);
//      for(int i = 0; i< allMap.length; i++){
//          for(int j =0; j < allMap[0].length; j ++){
//              System.out.print(allMap[i][j]);
//          }
//          System.out.println();
//
//      }


    return answer;
  }
  private void move(int characterX, int characterY){
    for(int i =0; i < 4; i++){

    }
  }
  private void makeMap(int[][] rectangle){
    for(int i =0; i < rectangle.length; i++){
      //아래
      for(int j = rectangle[i][0]; j <= rectangle[i][2]; j++)
        allMap[rectangle[i][1]][j] = 1;
      //왼쪽
      for(int j = rectangle[i][1]; j <= rectangle[i][3]; j++)
        allMap[j][rectangle[i][0]] = 1;
      //오른쪽
      for(int j = rectangle[i][1]; j <= rectangle[i][3]; j++)
        allMap[j][rectangle[i][2]] = 1;
      //위
      for(int j = rectangle[i][0]; j <= rectangle[i][2]; j++)
        allMap[rectangle[i][3]][j] = 1;
    }
  }
  private void colorMap(int[][] rectangle){

    for(int i =0; i < rectangle.length; i++){
      for(int j = 0; j< rectangle[i][0] - rectangle[i][2]; j++){
        allMap[][] =
      }
    }
  }
}
