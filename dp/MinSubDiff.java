package dp;

import java.util.Arrays;

public class MinSubDiff {

    public int minDifference(int nums[], int n) {

        int range = 0;
        for(int i = 0; i< n; i++){
            range += Math.abs(nums[i]);
        }
        int sum = range/2;
        boolean[][] dp = new boolean[n + 1][ sum + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if( i == 0 && j > 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){

                 if(Math.abs(nums[i - 1]) > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    boolean left = dp[i - 1][j - Math.abs(nums[i - 1])];
                    boolean right = dp[i - 1][j];
                    dp[i][j] =  left || right;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++) {
            if(dp[n][i]){
                if(nums[i] < 0){
                    min = Math.min(min, (range/2) - (-i));
                }else{
                    min = Math.min(min, (range/2) - i);
                }

            }

        }
        return min;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arr = { -36,36};


        new MinSubDiff().minDifference(arr,n);
    }
}
