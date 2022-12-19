package backtracking;

import java.util.Arrays;

public class AllPaths {

    public static void main(String[] args) {

       // printAllPath(3, 3, 0, 0,"");

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        //int[][] path = new int[maze.length][maze.length];
        //allPath("", maze, 0, 0, path, 1);

        int[][] board = new int[4][4];
        nQueue(board, 0,0);


    }

    public static void allPath(String p, boolean[][] maze, int r, int c, int[][] path, int step){

        if(r == maze.length - 1 && c == maze[0].length - 1){

            System.out.println(p);

            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();

            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;
        if(r <  maze.length - 1){
            allPath(p + "D", maze, r + 1, c, path, step +1);
        }

        if(c <maze[0].length - 1){
            allPath(p + "R", maze, r, c + 1, path, step +1);
        }

        if(r > 0){
            allPath(p + "U", maze, r -1, c, path, step +1);
        }

        if(c > 0){
            allPath(p + "L", maze, r, c - 1, path, step +1);
        }

       maze[r][c] = true;
       path[r][c] = 0;
    }


    public static void printAllPath(int rowCnt, int colCnt, int row, int col, String path){
        if(row == rowCnt - 1 && col == colCnt - 1){
            System.out.println(path);
            return;
        }

        if(row < rowCnt){
            printAllPath(rowCnt, colCnt, row+1, col, path+"D");
        }
        if(col < colCnt){
            printAllPath(rowCnt, colCnt, row, col+1, path+"L");
        }

        return;
    }


    public static void nQueue(int[][] board, int row, int col){

        if(row == board.length){
            for(int[] boardRow: board){
                System.out.println(Arrays.toString(boardRow));
            }
            System.out.println();
        }

        for(int c = 0; c < board[0].length; c++){
            boolean isSafe = isSafe(board, row, c);
            if(isSafe){
                board[row][c] = 1;
                nQueue(board, row+1, c);
                board[row][c] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        //vertical check
        for(int i = 0; i < row; i++){
            if(board[i][col] == 1) return false;
        }

        //check left diagonal
        int leftDownStep = Math.min(row, col);
        for(int i = 1; i<=leftDownStep; i++){
            if(board[row-i][col - i] == 1) return false;
        }

        //check right diagonal
        int rightDownStep = Math.min(row, board.length - col -1);
        for(int i = 1; i <= rightDownStep; i++){
            if(board[row -1][col + 1] == 1) return false;
        }

        return true;
    }
}
