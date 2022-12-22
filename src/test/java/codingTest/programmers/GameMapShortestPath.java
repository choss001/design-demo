package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

@Slf4j
public class GameMapShortestPath {
//  private static int[][] maps = {
//          {1,0,1,1,1},
//          {1,0,1,0,1},
//          {1,0,1,1,1},
//          {1,1,1,0,1},
//          {0,0,0,0,1}
//  };

    private static int[][] maps = {
            {1, 1, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1}
    };
    private static int answer = 9999999;
    private static int count = 1;
    private static int x = 0;
    private static int y = 0;

    @Test
    void solution() {
        int x = 0;
        int y = 0;
        //주석추가
        move();
        if (answer == 9999999) {
            log.info("restult : {}", -1);
        } else {
            log.info("restult : {}", answer);
        }
    }

    private void move() {
        log.info("#################################################");
//        printMaps();
        printFile();
        log.info("#################################################");
        if (x == maps[0].length -1 && y == maps.length -1) {
            answer = Math.min(answer, count);
            return;
        }
        moveUp();
        moveRight();
        moveDown();
        moveLeft();
    }

    private void printMaps(){
        Arrays.stream(maps).forEach(i -> {
            log.info("{}         x: {}, y: {}",Arrays.toString(i),x,y);
        });
    }
    private void printFile(){
//        File file = new File("C:\\Users\\qsw233\\Desktop\\project\\test.txt");
        File file = new File("C:\\Users\\CHLOE\\Desktop\\seongSik\\test.txt");
        try(FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write("#################################################\n");
            Arrays.stream(maps).forEach(i -> {
                String format = String.format("%s         X:%d, Y:%d, count:%d\n", Arrays.toString(i), x, y, count);
                try {
                    fileWriter.write(format);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void moveUp() {
        if (up()) {
            count++;
            move();
            reverseUp();
            count--;
        }
    }

    private void moveRight() {
        if (right()) {
            count++;
            move();
            reverseRight();
            count--;
        }
    }

    private void moveDown() {
        if (down()) {
            count++;
            move();
            reverseDown();
            count--;
        }

    }

    private void moveLeft() {
        if (left()) {
            count++;
            move();
            reverseLeft();
            count--;
        }
    }

    private boolean up() {
        if (y - 1 < 0)
            return false;
        if (maps[y - 1][x] == 0)
            return false;
        maps[y][x] = 0;
        y -= 1;
        maps[y][x] = 0;
        return true;
    }

    private boolean reverseUp() {
        maps[y][x] = 1;
        y += 1;
        maps[y][x] = 1;
        return true;
    }

    private boolean down() {
        if (y + 1 > maps.length -1)
            return false;
        if (maps[y + 1][x] == 0)
            return false;
        maps[y][x] = 0;
        y += 1;
        maps[y][x] = 0;
        return true;
    }

    private boolean reverseDown() {
        maps[y][x] = 1;
        y -= 1;
        maps[y][x] = 1;
        return true;
    }

    private boolean left() {
        if (x - 1 < 0)
            return false;
        if (maps[y][x - 1] == 0)
            return false;
        maps[y][x] = 0;
        x -= 1;
        maps[y][x] = 0;
        return true;
    }
    private boolean reverseLeft() {
        maps[y][x] = 1;
        x += 1;
        maps[y][x] = 1;
        return true;
    }

    private boolean right() {
        if (x + 1 > maps[0].length -1)
            return false;
        if (maps[y][x + 1] == 0)
            return false;
        maps[y][x] = 0;
        x += 1;
        maps[y][x] = 0;
        return true;
    }
    private boolean reverseRight() {
        maps[y][x] = 1;
        x -= 1;
        maps[y][x] = 1;
        return true;
    }
}
