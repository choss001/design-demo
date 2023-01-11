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

    public int solution(int[][] game_board, int[][] table) {
        usedCheck = new boolean[table.length][table[0].length];
        int answer = -1;
        getPuzzlePiece(table);

        getEmptyPuzzleRowColumn();
        cutEmptyPuzzle();
        makeTurnPuzzlePiece();
        System.out.println("turned Puzzle list size () :"+turnedPuzzleList.size());
//      printTurnedPuzzle();
        List<int[]> emptyArray = new ArrayList<>();
        boolean[][] usedCheckEmpty = new boolean[game_board.length][game_board[0].length];
        List<int[]> valueResult = getGameEmptyBlock(2, 0, game_board, emptyArray, usedCheckEmpty);
        for(int i =0; i < valueResult.size(); i++){
            int[] tempArray = valueResult.get(i);
            System.out.printf("x : %d   y : %d\n", tempArray[0], tempArray[1]);
        }
        return answer;
    }
    private void printTurnedPuzzle(){
        for(int i = 0; i< turnedPuzzleList.size(); i++){
            int[][] turnedPuzzle = turnedPuzzleList.get(i);

            System.out.println();
            for(int j= 0; j < turnedPuzzle.length; j++){
                System.out.println();
                for(int k =0; k < turnedPuzzle[0].length; k++){
                    System.out.printf("%d ",turnedPuzzle[j][k]);
                }
            }
        }
    }
    private List<int[]> getGameEmptyBlock(int x, int y, int[][] gameBoard, List<int[]> emptyArray, boolean[][] usedCheck){
        for(int k = 0; k < 4; k++){
            int dx = x + xMove[k];
            int dy = y + yMove[k];
            if(dx < 0 || dx >= gameBoard[0].length ||
                    dy < 0 || dy >= gameBoard.length)
                continue;
            if(gameBoard[dy][dx] == 0 && usedCheck[dy][dx] == false){
                emptyArray.add(new int[]{dx, dy});
                usedCheck[dy][dx] = true;
                getGameEmptyBlock(dx, dy, gameBoard, emptyArray, usedCheck);
            }

        }
        return emptyArray;
    }

    private void getEmptyPuzzleRowColumn(){

        for(int i =0; i < puzzleList.size(); i++){
            int[][] puzzleArray = puzzleList.get(i);
            List<Integer> row = new ArrayList<>();
            List<Integer> column = new ArrayList<>();
            for(int j =0; j < puzzleArray.length; j++){
                boolean tempRowFlag = false;
                boolean tempColumnFlag = false;
                for(int k = 0; k < puzzleArray[0].length; k++){
                    if(puzzleArray[j][k] == 1)
                        tempRowFlag = true;
                    if(puzzleArray[k][j] == 1)
                        tempColumnFlag = true;

                }
                if(tempRowFlag)
                    row.add(j);
                if(tempColumnFlag)
                    column.add(j);
            }
            rowList.add(row);
            columnList.add(column);
        }
    }

    private void cutEmptyPuzzle(){
        for(int i =0; i < puzzleList.size(); i++){
            int[][] puzzleArray = puzzleList.get(i);
            List<Integer> mapRow = rowList.get(i);
            List<Integer> mapColumn = columnList.get(i);
            int[][] newPuzzleArray =
                    new int[mapRow.size()][mapColumn.size()];

            int columnValue = 0;
            for(int j = mapColumn.get(0); j < mapColumn.get(0) + mapColumn.size(); j++){
                int rowValue = 0;
                for(int k =mapRow.get(0); k< mapRow.get(0) + mapRow.size(); k++){
                    newPuzzleArray[rowValue++][columnValue] = puzzleArray[k][j];
                }
                columnValue++;
            }

            compactPuzzleList.add(newPuzzleArray);
        }
    }

    private void getPuzzlePiece(int[][] table){
        for(int i =0; i< table.length; i++){
            for(int j =0; j < table.length; j++){
                if(table[i][j] == 1 &&
                        usedCheck[i][j] == false){
                    int[][] getPuzzle = new int[table.length][table[0].length];
                    getPuzzle[i][j] = 1;
                    puzzleList.add(getPuzzleRecursive(table, j, i, getPuzzle));
                }
            }
        }
    }

    private int[][] getPuzzleRecursive(int[][] table, int x, int y, int[][] getPuzzle){
        for(int i= 0; i < 4; i++){
            int dx = xMove[i] + x;
            int dy = yMove[i] + y;

            if((dx < 0 || dx >= table[0].length) ||
                    (dy < 0 || dy >= table.length))
                continue;

            if(table[dy][dx] == 1  &&
                    getPuzzle[dy][dx] == 0){
                getPuzzle[dy][dx] = 1;
                usedCheck[dy][dx] = true;
                getPuzzleRecursive(table, dx, dy, getPuzzle);
            }
        }
        return getPuzzle;
    }

    private void makeTurnPuzzlePiece(){
        for(int h = 0; h < compactPuzzleList.size(); h++){

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
    private int[][] turnPuzzlePiece(int[][] basePuzzle){
        int[][] turnedPuzzle = new int[basePuzzle[0].length][basePuzzle.length];
        for(int i =0; i < basePuzzle.length; i++){
            for(int j =0; j < basePuzzle[0].length; j++){
                turnedPuzzle[j][basePuzzle.length -1 - i] = basePuzzle[i][j];
            }
        }
        return turnedPuzzle;
    }}