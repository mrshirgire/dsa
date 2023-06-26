package dp;

import java.util.Arrays;

public class Knapsack {

    static int[][] T = new int[4][11];

    public static void main(String[] args) {
        int[] weights = {4,5,1};
        int[] values = {1,2,3};
        int W = 4;
        System.out.println(bottomUp(weights, values,W, values.length));
    }

//    public static int maxProfit(int[] weights, int[] values, int W, int n){
//
//        if(W == 0 || n == 0)
//            return 0;
//
//        if(T[n][W] != -1)
//            return  T[n][W];
//
//        if(weights[n-1] > W){
//            T[n][W] = maxProfit(weights, values, W, n - 1);
//            return T[n][W];
//        }else{
//
//            T[n][W] = Math.max(values[n-1] + maxProfit(weights, values, W - weights[n-1], n - 1),
//                    maxProfit(weights, values, W, n - 1));
//            return T[n][W];
//        }
//    }

    public static int bottomUp(int[] weights, int[] values, int W, int n){

        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j<= W; j++){

                if(i==0 || j == 0){
                    dp[i][j] = 0;
                }else{

                    int take = Integer.MIN_VALUE;
                    if(weights[i - 1] <= j){
                        take = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    }
                    int notTake = dp[i - 1][j];

                    dp[i][j] = Math.max(take, notTake);
                }
        }
        }
        return dp[n][W];
    }

//    public static int topDown_(int[] weights, int[] values, int W, int length){
//
//        for(int n = 0; n <= length ; n++) {
//            for(int w = 0; w<= W; w++){
//
//                if(n == 0 || w == 0){
//                    T[n][w] = 0;
//                }else if(weights[n - 1] <= w){
//                    T[n][w] = Math.max(values[ n - 1] + T[n -1][w - weights[n - 1]], T[n - 1][w]);
//                } else{
//                    T[n][w] = T[n - 1][w];
//                }
//            }
//        }
//
//        return T[length][W];
//    }

//    public static int maxProfit_(int[] weights, int[] values, int W, int n){
//
//        if(W == 0 || n == 0 )
//            return 0;
//
//        if(weights[n-1] > W){
//            return maxProfit_(weights, values, W, n - 1);
//        }else{
//            int left = values[n-1] + maxProfit_(weights, values, W - weights[n - 1], n - 1);
//            int right = maxProfit_(weights, values, W, n - 1);
//
//            return Math.max(left, right);
//        }
//    }
//
//
//    public static int minCoin(int n, int sum, int[] coins){
//        if(sum == 0) return 0;
//        if(n == 0 && sum!=0) return -1;
//
//        if(coins[n-1] <= sum){
//            int left = minCoin(n, sum-coins[n-1], coins);
//            left = left == -1 ? 0 : left;
//
//            int right = minCoin(n-1, sum, coins);
//            right = right == -1? 0: right;
//
//            return Math.min(left, right) + 1;
//        }else{
//            int ans = minCoin(n-1, sum, coins);
//            return ans == -1 ? 0: ans;
//
//        }
//    }

//    public static int minCoinDp(int n, int sum, int[] coins){
//        int[][] dp = new int[n+1][sum+1];
//        for(n = 0; n <= coins.length; n++){
//            for(int s = 0; s <=sum; s++){
//                if(s == 0){
//                    dp[n][s] = 0;
//                }else if(n==0 && s!=0){
//                    dp[n][s] = -1;
//                }else{
//                    if(coins[n-1] <= sum){
//                        int left = dp[n][s-coins[n-1]];
//                        left = left == -1 ? 0 : left;
//
//                        int right = dp[n-1][s];
//                        right = right == -1? 0: right;
//
//                        dp[n][s]  = Math.min(left, right) + 1;
//                    }else{
//                        int ans  =  dp[n-1][s];
//                        dp[n][s]  = ans == -1 ? 0: ans;
//                    }
//                }
//            }
//        }
//
//        return dp[n][sum];
//    }
//
//    static int fun(int index, int[] weight, int[] value, int maxWeight, int[][] dp){
//
//        if(maxWeight == 0) return 0;
//        if(index == 0){
//            return weight[0] <= maxWeight ? value[0]: 0;
//        }
//
//        if(dp[index][maxWeight] != -1) return dp[index][maxWeight];
//
//        int take = Integer.MIN_VALUE;
//        if(weight[index] <= maxWeight){
//            take = value[index] + fun(index - 1, weight, value, maxWeight - weight[index], dp);
//        }
//
//        int notTake = fun(index - 1, weight, value, maxWeight, dp);
//        return dp[index][maxWeight] = Math.max(take, notTake);
//    }
//
//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//
//       int[] prev = new int[maxWeight + 1];
//        for(int i = weight[0]; i <= maxWeight; i++){
//            prev[i] = value[0];
//        }
//
//        for(int i = 1; i< n; i++){
//            int[] curr = new int[maxWeight + 1];
//            for(int j = 1; j <= maxWeight; j++){
//
//                int take = Integer.MIN_VALUE;
//                if(weight[i] <= j){
//                    take = value[i] + prev[j - weight[i]];
//                }
//
//                int notTake = prev[j];
//                curr[j] = Math.max(take, notTake);
//            }
//            prev = curr;
//        }
//
//        return prev[maxWeight];
//    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[] prev = new int[maxWeight + 1];
        for(int i = weight[0]; i <= maxWeight; i++){
            prev[i] = value[0];
        }

        for(int i = 1; i< n; i++){
            for(int j = maxWeight; j >= 0; j--){

                int take = Integer.MIN_VALUE;
                if(weight[i] <= j){
                    take = value[i] + prev[j - weight[i]];
                }

                int notTake = prev[j];
                prev[j] = Math.max(take, notTake);
            }
        }

        return prev[maxWeight];
    }

}
