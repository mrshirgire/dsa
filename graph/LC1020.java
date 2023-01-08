package graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC1020 {

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Cell> q = new LinkedList<>();
        for(int col = 0; col < m; col++){
            if(grid[0][col] == 1){
                q.add(new Cell(0, col));
                grid[0][col] =  2;
            }
            if(grid[ n - 1][col] == 1){
                q.add(new Cell(n - 1, col));
                grid[n - 1][col] = 2;
            }
        }

        for(int row = 1; row < n - 1; row++){

            if(grid[row][0] == 1){
                q.add(new Cell(row, 0));
                grid[row][0] = 2;
            }
            if(grid[row][m - 1] == 1){
                q.add(new Cell(row, m - 1));
                grid[row][m - 1] = 2;
            }
        }

        int[][] dir =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){

            Cell currCell = q.poll();
            for(int i =0; i < dir.length; i++){

                int nextRow = currCell.row + dir[i][0];
                int nextCol = currCell.col + dir[i][1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
                    if(grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 2;
                        q.add(new Cell(nextRow, nextCol));
                    }
                }
            }
        }
        int count = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

        //int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int ans = new LC1020().numEnclaves(grid);
        System.out.println(ans);
    }
}
