package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Slf4j
public class FillPuzzlePieces {

    private int[][] game_board = new int[][]{
            {1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0}
    };

    private int[][] table = new int[][]{
            {1, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0}
    };
    private List<int[][]> puzzleList = new ArrayList<>();
    //used for cache that memorized checking once value
    private boolean[][] usedCheck;
    private int[] xMove = {1, 0, -1, 0};
    private int[] yMove = {0, 1, 0, -1};


    //this value use for get empty row and column
    List<HashSet<Integer>> rowList = new ArrayList<>();
    List<HashSet<Integer>> columnList = new ArrayList<>();

    @Test
    void test() {

    }

    public int solution(int[][] game_board, int[][] table) {
        usedCheck = new boolean[table.length][table[0].length];
        int answer = -1;
        getPuzzlePiece(table);
        System.out.println("puzzleList size () : " + puzzleList.size());
        for (int x = 0; x < puzzleList.size(); x++) {
            int[][] getPuzzleArray = puzzleList.get(x);
            for (int i = 0; i < table.length; i++) {
                System.out.println();
                for (int j = 0; j < table[0].length; j++) {
                    System.out.printf("%d ", getPuzzleArray[i][j]);
                }
            }
            System.out.println();
        }
        getEmptyPuzzleRowColumn();
        cutEmptyPuzzle();
        return answer;
    }

    private void getEmptyPuzzleRowColumn() {

        for (int i = 0; i < puzzleList.size(); i++) {
            int[][] puzzleArray = puzzleList.get(i);
            Map<Integer, Integer> row = new HashMap<>();
            Map<Integer, Integer> column = new HashMap<>();
            for (int j = 0; j < puzzleArray.length; j++) {
                boolean tempRowFlag = true;
                boolean tempColumnFlag = true;
                Integer tempColumn = 0;
                for (int k = 0; k < puzzleArray[0].length; k++) {
                    if (puzzleArray[j][k] == 1)
                        tempRowFlag = false;
                    if (puzzleArray[k][j] == 1)
                        tempColumnFlag = false;

                }
                if (tempRowFlag)
                    row.put(j, 1);
                if (tempColumnFlag)
                    column.put(j, 1);
            }
            rowList.add(row);
            columnList.add(column);
        }
        System.out.print("row : ");
        for (int i = 0; i < rowList.size(); i++) {
            System.out.print(rowList.get(i));
        }
        System.out.println();
        System.out.print("column : ");
        for (int i = 0; i < columnList.size(); i++) {
            System.out.print(columnList.get(i));
        }
    }

    private void cutEmptyPuzzle() {

//      private List<int[][]>  puzzleList = new ArrayList<>();
//      private boolean[][] usedCheck;
//      private int[] xMove = {1, 0, -1, 0};
//      private int[] yMove = {0, 1, 0, -1};

//      List<Map<Integer, Integer>> rowList = new ArrayList<>();
//      List<Map<Integer, Integer>> columnList = new ArrayList<>();

        for (int i = 0; i < puzzleList.size(); i++) {
            int[][] puzzleArray = puzzleList.get(i);
            Map<Integer, Integer> mapRow = rowList.get(i);
            Map<Integer, Integer> mapColumn = columnList.get(i);
            int[][] newPuzzleArray =
                    new int[puzzleArray.length - mapRow.size()][puzzleArray.length - mapColumn.size()];

            int startRowValue = -1;
            int startColumnValue = -1;
            for (int j = 0; j < puzzleArray.length; j++) {
                if (mapRow.getOrDefault(j, 0) == 0) {
                    if (startRowValue < 0)
                        startRowValue = 0;
                    else
                        startRowValue++;
                    for (int k = 0; k < puzzleArray[0].length; k++) {
                        newPuzzleArray[startRowValue][k] = puzzleArray[j][k];
                    }
                }
                if (mapColumn.getOrDefault(j, 0) == 0) {

                    if (startColumnValue < 0)
                        startColumnValue = 0;
                    else
                        startColumnValue++;
                    for (int k = 0; k < puzzleArray[0].length; k++) {
                        newPuzzleArray[startColumnValue][k] = puzzleArray[j][k];
                    }
                }

            }

            //print new PuzzleArray
            for (int l = 0; l < newPuzzleArray.length; l++) {
                System.out.println();
                for (int m = 0; m < newPuzzleArray[0].length; m++) {
                    System.out.printf("%d ", newPuzzleArray[l][m]);
                }
            }
            System.out.println("\n##########################");
        }
    }

    private void getPuzzlePiece(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 1 &&
                        usedCheck[i][j] == false) {
                    int[][] getPuzzle = new int[table.length][table[0].length];
                    getPuzzle[i][j] = 1;
                    puzzleList.add(getPuzzleRecursive(table, j, i, getPuzzle));
                }
            }
        }
    }

    private int[][] getPuzzleRecursive(int[][] table, int x, int y, int[][] getPuzzle) {
        for (int i = 0; i < 4; i++) {
            int dx = xMove[i] + x;
            int dy = yMove[i] + y;

            if ((dx < 0 || dx >= table[0].length) ||
                    (dy < 0 || dy >= table.length))
                continue;

            if (table[dy][dx] == 1 &&
                    getPuzzle[dy][dx] == 0) {
                getPuzzle[dy][dx] = 1;
                usedCheck[dy][dx] = true;
                getPuzzleRecursive(table, dx, dy, getPuzzle);
            }
        }
        return getPuzzle;
    }

    private void turnPuzzlePiece() {

    }
}