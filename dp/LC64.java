package dp;

import java.nio.file.Path;
import java.util.Arrays;

public class LC64 {

    static int m;
    static int n;
    static int[][] dp;
    static int[][] dirs1 = {{-1, 0}, {0, -1}};
    static int findMinPath(int[][] grid){
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int  i= 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        minPath(m - 1, n - 1, grid);
        return dp[m -1][n -1];
    }

    public static int minPath(int row, int col, int[][] grid){

        if(row == 0 && col == 0) {
            return grid[row][col];
        }

        if(dp[row][col] != -1)
            return dp[row][col];


        int sum = Integer.MAX_VALUE;
        for(int[] dir: dirs1){

            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow >= 0 && nextCol >= 0) {
                int ans = grid[row][col] + minPath(nextRow, nextCol, grid);
                sum = Math.min(sum, ans);
            }
        }

        return dp[row][col]  = sum;
    }

    int tabulationMinPath(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] dirs = {{1, 0}, {0, 1}};

        dp[0][0] =  grid[0][0];
        for(int row = 0; row < m; row++){
            for(int col = 1; col< n; col++){


                int sum = Integer.MAX_VALUE;
                for(int[] dir: dirs){

                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if(nextRow < m && nextCol < n) {
                        int ans = grid[row][col] + minPath(nextRow, nextCol, grid);
                        sum = Math.min(sum, ans);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        //int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,3},{1,5}};
       // System.out.println(minPathSum(grid));
        int m = grid.length - 1;
        int n = grid[0].length -1;
      // System.out.println(minPath(m,n, grid));

        int ans = findMinPath(grid);
        System.out.println();
       // System.out.println(minPathSum(grid));
    }
}
