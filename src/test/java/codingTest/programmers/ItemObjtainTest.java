package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class ItemObjtainTest {
    private int[] y = {1, 0, -1, 0};
    private int[] x = {0, 1, 0, -1};
    private static int[][] allMap = new int[50][50];
    private int answer = Integer.MAX_VALUE;
    private int itemX;
    private int itemY;

    private static final int[][] RECTANGLE = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
    private static final int CHARACTER_X = 1;
    private static final int CHARACTER_Y = 3;
    private static final int ITEM_X = 7;
    private static final int ITEM_Y = 8;
    private static final int result = 17;

    @Test
    void test1(){
        int solution = solution(RECTANGLE, CHARACTER_X, CHARACTER_Y, ITEM_X, ITEM_Y);
        log.info("restul : {}", solution);

    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.itemX = itemX * 2;
        this.itemY = itemY * 2;

        int[][] multipleTwo = multipleTwo(rectangle);
        makeMap(multipleTwo);
        colorMap(multipleTwo);
        allMap[characterY][characterX] = 9;
        move(characterX * 2, characterY * 2);
        for (int i = 49; i >= 0; i--) {
            for (int j = 0; j < 50; j++) {
                System.out.print(allMap[i][j]);
            }
            System.out.println();

        }


        return answer;
    }

    private void move(int characterX, int characterY) {
        if (characterX == itemX && characterY == itemY) {
            answer = Math.min(allMap[characterY][characterX] - 1, answer);
            return;
        }
        Queue<int[]> queue = new LinkedList<>();

        int dx = characterX;
        int dy = characterY;
        queue.add(new int[]{});
        while(!queue.isEmpty()){
            for (int i = 0; i < 4; i++) {
                if (allMap[dy + y[i]][dx + x[i]] == 1) {
                    queue.add(new int[]{dx, dy, 1});
                    dy += y[i];
                    dx += x[i];
                    allMap[dy][dx] += 5;
                }
            }
        }
    }

    private int[][] multipleTwo(int[][] rectangle){
        int[][] multipleRec = new int[rectangle.length][4];
        for (int i = 0; i < rectangle.length; i++)
            for(int j=0; j < 4; j++)
                multipleRec[i][j] = 2 * rectangle[i][j];
        return multipleRec;
    }
    private void makeMap(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            //아래
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++)
                allMap[rectangle[i][1]][j] = 1;
            //왼쪽
            for (int j = rectangle[i][1]; j <= rectangle[i][3]; j++)
                allMap[j][rectangle[i][0]] = 1;
            //오른쪽
            for (int j = rectangle[i][1]; j <= rectangle[i][3]; j++)
                allMap[j][rectangle[i][2]] = 1;
            //위
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++)
                allMap[rectangle[i][3]][j] = 1;
        }
    }

    private void colorMap(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i][2] - rectangle[i][0] - 1; j++) {
                for (int l = 0; l < rectangle[i][3] - rectangle[i][1] - 1; l++) {
                    allMap[rectangle[i][1] + 1 + l][rectangle[i][0] + 1 + j] = 2;

                }
            }
        }
    }
}
