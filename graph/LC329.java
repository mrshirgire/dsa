package graph;

public class LC329 {

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public  int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] vis = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                dp[i][j] = 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                int temp = dfs(row, col, 0 ,vis, matrix, n, m, dp);
                max = Math.max(max, temp);
            }
        }

        return max ;

    }

    int dfs(int row, int col, int count, int[][] vis, int[][] matrix, int n, int m, int[][] dp){

        vis[row][col] = 1;

        for(int i = 0; i < dir.length; i++){
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];
            if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
                if(matrix[nextRow][nextCol] > matrix[row][col] && vis[nextRow][nextCol] == 0){

                    int temp = 0;
                    if(dp[nextRow][nextCol] ==  1){
                        temp = dfs(nextRow, nextCol, count, vis, matrix, n, m, dp) + 1;
                    }else{
                        temp = dp[nextRow][nextCol] + 1;
                    }

                    dp[row][col] = Math.max(dp[row][col], temp);
                }
            }
        }

        return  dp[row][col];

    }

    public static void main(String[] args) {
        LC329 lc329 = new LC329();
        //int[][] matrix = {{1,2}};
        int[][] matrix ={{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(lc329.longestIncreasingPath(matrix));;
    }
}
