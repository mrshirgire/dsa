package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC931 {

    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {


        int n = matrix.length;
        int m = matrix[0].length;

        dp =new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <m; j++){
                dp[i][j] = (int) 1e7;
            }
        }
        if(n == 1 && m == 1)
            return matrix[0][0];

        int min = (int) 1e7;
        for(int i = 0; i < m; i++){
            int ans = minPath(0, i, matrix, n, m);
            min = Math.min(ans, min);
        }


        return min;

    }

    int minPath(int row, int col, int[][] matrix, int n, int m){

        if(row == n - 1 && col < m -1 && col >=0){
            return matrix[row][col];
        }

        if(row > n  - 1 || col < 0 || col > m -1)
            return (int) 1e7;;

          /*  if(dp[row][col] != (int) 1e7)
                return dp[row][col];*/

        int down  = matrix[row][col] + minPath(row + 1, col, matrix, n, m);
        int leftDiagonal  = matrix[row][col] + minPath(row + 1, col + 1, matrix, n, m);
        int rightDiagonal  = matrix[row][col] + minPath(row + 1, col - 1, matrix, n, m);

        int min = Math.min(down, leftDiagonal);
        min = Math.min(min, rightDiagonal);

        return  /*dp[row][col] =*/ min;

    }


    //recursive ways

    int minPath(int row, int col, int[][] matrix, int[][] dp){

        if( col > matrix.length -1 || col < 0)
            return (int) 1e9;

        if(row == 0) return matrix[row][col];

        if(dp[row][col] != -1) return dp[row][col];
        int up = matrix[row][col] + minPath(row -1, col, matrix, dp);
        int leftDiagonal =  matrix[row][col] + minPath(row - 1, col - 1, matrix, dp);
        int rightDiagonal =  matrix[row][col] + minPath(row - 1, col - 1, matrix, dp);

        Integer[] num = { up, leftDiagonal, rightDiagonal};
        return dp[row][col] = Collections.min(Arrays.asList(num));


    }


    public static void main(String[] args) {
       int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        //int[][] matrix = {{17,82},{1,-44}};

        LC931 lc931 = new LC931();
       // System.out.println(lc931.minFallingPathSum(matrix));
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(lc931.minPath(matrix.length -1, matrix[0].length -1, matrix, dp));
        System.out.println();
    }
}
