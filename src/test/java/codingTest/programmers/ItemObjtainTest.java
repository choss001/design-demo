package codingTest.programmers;

public class ItemObjtainTest {
    private int[] y = {1, 0, -1, 0};
    private int[] x = {0, 1, 0, -1};
    private static int[][] allMap = new int[50][50];
    private int answer = Integer.MAX_VALUE;
    private int itemX;
    private int itemY;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.itemX = itemX;
        this.itemY = itemY;

        makeMap(rectangle);
        colorMap(rectangle);
        allMap[characterY][characterX] = 9;
//      move(characterX, characterY);
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

        int dx = characterX;
        int dy = characterY;
        for (int i = 0; i < 4; i++) {
            if (allMap[dy + y[i]][dx + x[i]] == 1) {
                dy += y[i];
                dx += x[i];
                allMap[dy][dx] += 5;
            }
        }
        move(dx, dy);
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
