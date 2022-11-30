package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class GameMapShortestPath {
  private static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
  private static int answer = 9999999;
  private static int count =0;
  private static int x =0;
  private static int y =0;

  @Test
  void solution() {
    int x = 0;
    int y = 0;
    move();
    if(answer == 9999999){
      log.info("restult : {}", answer);
    }else{
      log.info("restult : {}", answer);
    }
  }
  private void move(){
//      System.out.printf("x : %d, y : %d", x, y);
    if(x == 4 && y == 4){
      answer = Math.min(answer, count);
      return;
    }
    if(count > 24){
      return;
    }
    moveUp();
    moveRight();
    moveDown();
    moveLeft();
  }
  private void moveUp(){
    if(up()){
      count++;
      move();
      down();
      count--;
    }
  }
  private void moveRight(){
    if(right()){
      count++;
      move();
      left();
      count--;
    }
  }
  private void moveDown(){
    if(down()){
      count++;
      move();
      up();
      count--;
    }

  }
  private void moveLeft(){
    if(left()){
      count++;
      move();
      right();
      count--;
    }
  }

  private boolean up(){
    if(y-1 < 0)
      return false;
    if(maps[y-1][x] == 0)
      return false;
    y -=1;
    return true;

  }
  private boolean down(){
    if(y+1 > 4)
      return false;
    if(maps[y+1][x] == 0)
      return false;
    y +=1;
    return true;
  }
  private boolean left(){
    if(x-1 <0)
      return false;
    if(maps[y][x-1] == 0)
      return false;
    x -=1;
    return true;
  }
  private boolean right(){
    if(x+1 >4)
      return false;
    if(maps[y][x+1] == 0)
      return false;
    x +=1;
    return true;
  }
//  {    x
//      {1,0,1,1,1} y
//      {1,0,1,1,1}
//      {1,0,1,1,1}
//      {1,0,1,1,1}
//      {1,0,1,1,1}
//  }

//  private static int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
}
