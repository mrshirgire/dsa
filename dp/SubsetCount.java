package dp;

public class SubsetCount {

    public int fun(int sum, int n, int[] nums){
        if(sum == 0) return 1;
        if(n == 0 && sum != 0) return 0;

        if(nums[n -1] <= sum){
            int left = fun(sum - nums[n-1], n - 1, nums);
            int right = fun(sum, n - 1, nums);

            return left + right;
        }

        return fun(sum, n -1, nums);
    }


    public int fun2(int sum, int n, int[] nums){
        int[][] dp  = new int[n + 1][sum + 1];
        for(int i =0; i <=n; i++){
            for(int j =0; j<=sum; j++){
                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }

                if( i == 0 && j != 0){
                    dp[i][j] = 0;
                    continue;
                }

                if(nums[i -1] <= j){
                    int left = dp[ i - 1][j - nums[i - 1]];
                    int right = dp[i - 1][j];

                    dp[i][j] = left + right;
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
