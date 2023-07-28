package dp;

import java.util.Arrays;

public class LC416 {

    public boolean canPartition(int[] nums) {

        int sum  = Arrays.stream(nums).sum();
        if( sum % 2 != 0) return false;

        int n = nums.length;
        sum = sum/2;
         boolean[][] dp = new boolean[n + 1][ sum + 1];

         for(int i = 0; i <= n; i++){
             for(int j = 0; j <= sum; j++){

                 if( i == 0 && j > 0){
                      dp[i][j] = false;
                 }else  if(j == 0){
                      dp[i][j] = true;
                 }else if(nums[i - 1] > j){
                      dp[i][j] = dp[i - 1][j];
                 }else{
                     boolean left = dp[i - 1][j - nums[i -1]];
                     boolean right = dp[i - 1][j];
                     dp[i][j] =  left || right;
                 }
             }
         }

         return dp[n][sum];
 }

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        new LC416().canPartition(arr);
    }
}
