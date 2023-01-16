package codingTest.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    void test() {

    }
    //used for each puzzle array
    private List<int[][]>  puzzleList = new ArrayList<>();
    private boolean[][] usedCheck;
    private int[] xMove = {1, 0, -1, 0};
    private int[] yMove = {0, 1, 0, -1};

    //this value use for get empty row and column
    List<List<Integer>> rowList = new ArrayList<>();
    List<List<Integer>> columnList = new ArrayList<>();
    List<int[][]> compactPuzzleList = new ArrayList();
    List<int[][]> turnedPuzzleList = new ArrayList();

    //is used gameBoard empty block check in method that name getGameEmptyBlock
    private boolean[][] usedCheckGameBoard;

    private int answer = -1;

    //used for each puzzle array
    public int solution(int[][] game_board, int[][] table) {
        usedCheck = new boolean[table.length][table[0].length];
        int answer = -1;
        getPuzzlePiece(table);

        getEmptyPuzzleRowColumn();
        cutEmptyPuzzle();
        makeTurnPuzzlePiece();
//      printTurnedPuzzle();
//      int[] rangeArray = getBooleanRange(5);

        List<int[]> emptyArray = new ArrayList<>();
        boolean[][] usedCheckEmpty = new boolean[game_board.length][game_board[0].length];
        List<int[]> valueResult = getGameEmptyBlock(2, 0, game_board, emptyArray, usedCheckEmpty);
        int[] maxMinValue = getMaxAndMinValue(valueResult);

        boolean[] turnedArrayUsedCheck = new boolean[turnedPuzzleList.size()];
        boolean[][] blankUsedCheck = new boolean[game_board.length][game_board[0].length];
//      correspondBlockFind(game_board, turnedArrayUsedCheck, 0, 0, blankUsedCheck);
        for (int i = 0; i < valueResult.size(); i++) {
            int[] tempArray = valueResult.get(i);
            System.out.printf("x : %d   y : %d\n", tempArray[0], tempArray[1]);
        }
        return answer;
    }

    private void printTurnedPuzzle() {
        for (int i = 0; i < turnedPuzzleList.size(); i++) {
            int[][] turnedPuzzle = turnedPuzzleList.get(i);

            System.out.println();
            for (int j = 0; j < turnedPuzzle.length; j++) {
                System.out.println();
                for (int k = 0; k < turnedPuzzle[0].length; k++) {
                    System.out.printf("%d ", turnedPuzzle[j][k]);
                }
            }
        }
    }

    private List<int[]> getGameEmptyBlock(int x, int y, int[][] gameBoard, List<int[]> emptyArray, boolean[][] usedCheck) {
        for (int k = 0; k < 4; k++) {
            int dx = x + xMove[k];
            int dy = y + yMove[k];
            if (dx < 0 || dx >= gameBoard[0].length ||
                    dy < 0 || dy >= gameBoard.length)
                continue;
            if (gameBoard[dy][dx] == 0 && usedCheck[dy][dx] == false) {
                emptyArray.add(new int[]{dx, dy});
                usedCheck[dy][dx] = true;
                getGameEmptyBlock(dx, dy, gameBoard, emptyArray, usedCheck);
            }

        }
        return emptyArray;
    }

    //now i am working
    private void correspondBlockFind(int[][] game_board, boolean[] turnedArrayUsedCheck, int y, int x, boolean[][] blankUsedCheck) {
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (i == game_board.length - 1 &&
                        j == game_board[0].length - 1) {
                    answer = Math.max(answer, 0);
                    for (int k = 0; k < blankUsedCheck.length; k++) {
                        System.out.println();
                        for (int l = 0; l < blankUsedCheck[0].length; l++) {
                            System.out.printf("%b ", blankUsedCheck[i][j]);
                        }
                    }
                }
                if (game_board[i][j] == 0) {
                    //빈 블랭크 범위 찾는 로직
                    List<int[]> emptyArray = new ArrayList<>();
                    boolean[][] usedCheckEmpty = new boolean[game_board.length][game_board[0].length];
                    List<int[]> valueResult = getGameEmptyBlock(2, 0, game_board, emptyArray, usedCheckEmpty);
                    //최소 최대값 이걸로 사이즈 찾아서 한결 쉬워질듯
                    int[] maxMinValue = getMaxAndMinValue(valueResult);
                    for (int k = 0; k < turnedPuzzleList.size(); k++) {
                        int[][] turnedPuzzleArray = turnedPuzzleList.get(k);
                        if (turnedPuzzleArray[0].length == (maxMinValue[1] - maxMinValue[0] + 1) &&
                                turnedPuzzleArray.length == (maxMinValue[3] - maxMinValue[2] + 1) &&
                                !blankUsedCheck[i][j]) {
                            if (checkAllBlankBlock(maxMinValue, game_board, turnedPuzzleArray)) {
                                int[] rangeArray = getBooleanRange(k);
                                usedCheckblankBooleanSetTrue(valueResult, blankUsedCheck);
                                turnedArrayUsedCheck[rangeArray[0]] = true;
                                turnedArrayUsedCheck[rangeArray[1]] = true;
                                turnedArrayUsedCheck[rangeArray[2]] = true;
                                turnedArrayUsedCheck[rangeArray[3]] = true;
                                correspondBlockFind(game_board, turnedArrayUsedCheck, i + 1, j + 1, blankUsedCheck);
                                usedCheckblankBooleanSetFalse(valueResult, blankUsedCheck);
                                turnedArrayUsedCheck[rangeArray[0]] = false;
                                turnedArrayUsedCheck[rangeArray[1]] = false;
                                turnedArrayUsedCheck[rangeArray[2]] = false;
                                turnedArrayUsedCheck[rangeArray[3]] = false;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean[][] usedCheckblankBooleanSetTrue(List<int[]> blankArrayList, boolean[][] usedCheckEmpty) {
        for (int i = 0; i < blankArrayList.size(); i++) {
            int[] blankArray = blankArrayList.get(i);
            usedCheckEmpty[blankArray[1]][blankArray[0]] = true;
        }
        return usedCheckEmpty;
    }

    private boolean[][] usedCheckblankBooleanSetFalse(List<int[]> blankArrayList, boolean[][] usedCheckEmpty) {
        for (int i = 0; i < blankArrayList.size(); i++) {
            int[] blankArray = blankArrayList.get(i);
            usedCheckEmpty[blankArray[1]][blankArray[0]] = false;
        }
        return usedCheckEmpty;
    }

    private int[] getBooleanRange(int k) {
        int upper = k;
        int under = k;
        for (int i = 0; i < 4; i++) {
            if (upper % 4 == 3)
                break;
            upper++;
        }
        System.out.println("upper range : " + upper);

        for (int i = 0; i < 4; i++) {
            if (under % 4 == 0)
                break;
            under--;
        }

        System.out.println("under range : " + under);
        int[] rangeArray = new int[4];
        int ini = 0;
        for (int i = under; i <= upper; i++) {
            rangeArray[ini++] = i;
        }
        return rangeArray;
    }

    private boolean checkAllBlankBlock(int[] maxMinValue, int[][] game_board, int[][] turnedPuzzleArray) {
        int y = 0;
        for (int j = maxMinValue[2]; j <= maxMinValue[3]; j++) {
            int x = 0;
            for (int i = maxMinValue[0]; i <= maxMinValue[1]; i++) {
                if (game_board[j][i] + turnedPuzzleArray[y][x++] != 1) {
                    return false;
                }
            }
            y++;
        }
        return true;
    }

    private int[] getMaxAndMinValue(List<int[]> blanksBlock) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for (int[] temp : blanksBlock) {
            xList.add(temp[0]);
            yList.add(temp[1]);
        }
        Collections.sort(xList);
        Collections.sort(yList);
        int[] returnValue = new int[4];
        returnValue[0] = xList.get(0);
        returnValue[1] = xList.get(xList.size() - 1);
        returnValue[2] = yList.get(0);
        returnValue[3] = yList.get(yList.size() - 1);
        return returnValue;
    }

    private void getEmptyPuzzleRowColumn() {

        for (int i = 0; i < puzzleList.size(); i++) {
            int[][] puzzleArray = puzzleList.get(i);
            List<Integer> row = new ArrayList<>();
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < puzzleArray.length; j++) {
                boolean tempRowFlag = false;
                boolean tempColumnFlag = false;
                for (int k = 0; k < puzzleArray[0].length; k++) {
                    if (puzzleArray[j][k] == 1)
                        tempRowFlag = true;
                    if (puzzleArray[k][j] == 1)
                        tempColumnFlag = true;

                }
                if (tempRowFlag)
                    row.add(j);
                if (tempColumnFlag)
                    column.add(j);
            }
            rowList.add(row);
            columnList.add(column);
        }
    }

    private void cutEmptyPuzzle() {
        for (int i = 0; i < puzzleList.size(); i++) {
            int[][] puzzleArray = puzzleList.get(i);
            List<Integer> mapRow = rowList.get(i);
            List<Integer> mapColumn = columnList.get(i);
            int[][] newPuzzleArray =
                    new int[mapRow.size()][mapColumn.size()];

            int columnValue = 0;
            for (int j = mapColumn.get(0); j < mapColumn.get(0) + mapColumn.size(); j++) {
                int rowValue = 0;
                for (int k = mapRow.get(0); k < mapRow.get(0) + mapRow.size(); k++) {
                    newPuzzleArray[rowValue++][columnValue] = puzzleArray[k][j];
                }
                columnValue++;
            }

            compactPuzzleList.add(newPuzzleArray);
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

    private void makeTurnPuzzlePiece() {
        for (int h = 0; h < compactPuzzleList.size(); h++) {

            int[][] turnedPuzzle = turnPuzzlePiece(compactPuzzleList.get(h));
            turnedPuzzleList.add(turnedPuzzle);
            turnedPuzzle = turnPuzzlePiece(turnedPuzzle);
            turnedPuzzleList.add(turnedPuzzle);
            turnedPuzzle = turnPuzzlePiece(turnedPuzzle);
            turnedPuzzleList.add(turnedPuzzle);
            turnedPuzzle = turnPuzzlePiece(turnedPuzzle);
            turnedPuzzleList.add(turnedPuzzle);

        }

    }

    private int[][] turnPuzzlePiece(int[][] basePuzzle) {
        int[][] turnedPuzzle = new int[basePuzzle[0].length][basePuzzle.length];
        for (int i = 0; i < basePuzzle.length; i++) {
            for (int j = 0; j < basePuzzle[0].length; j++) {
                turnedPuzzle[j][basePuzzle.length - 1 - i] = basePuzzle[i][j];
            }
        }
        return turnedPuzzle;
    }
}