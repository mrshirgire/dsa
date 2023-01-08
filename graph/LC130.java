package graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC130 {

    char[][] ans;
    int[][] dir =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public char[][] solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        ans = new char[m][n];
        Queue<Cell> q = new LinkedList<>();
        for(int col = 0; col < m; col++){
            if(board[0][col] == 'O'){
                q.add(new Cell(0, col));
                board[0][col] = 'N';
            }
            if(board[ n - 1][col] == 'O'){
                q.add(new Cell(n - 1, col));
                board[n - 1][col] = 'N';
            }
        }

        for(int row = 1; row < n - 1; row++){
            if(board[row][0] == 'O'){
                q.add(new Cell(row, 0));
                board[row][0] = 'N';
            }
            if(board[row][m - 1] == 'O'){
                q.add(new Cell(row, m - 1));
                board[row][m - 1] = 'N';
            }
        }

        while(!q.isEmpty()){

            Cell currCell = q.poll();
            for(int i =0; i < dir.length; i++){

                int nextRow = currCell.row + dir[i][0];
                int nextCol = currCell.col + dir[i][1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
                    if(board[nextRow][nextCol] == 'O'){
                        board[nextRow][nextCol] = 'N';
                        q.add(new Cell(nextRow, nextCol));
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }


            }
        }

        return board;

    }

    public static void main(String[] args) {
        char[][] board = {
                            {'X','X','X','X'},
                            {'X','O','O','X'},
                            {'X','X','O','X'},
                            {'X','O','X','X'}
                        };
        System.out.println();
        char[][] ans = new LC130().solve(board);
        System.out.println(ans);

    }
}

