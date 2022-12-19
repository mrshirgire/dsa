package dp;

import java.util.Arrays;

public class Knapsack {

    static int[][] T = new int[4][11];

    public static void main(String[] args) {
//        int[] weights = {5, 2, 11};
//        int[] values = {1000, 200, 600};
//        int W = 10;


        /*for(int i=0;i<4; i++){
            for(int j=0;j<11; j++){
                T[i][j] = -1;
            }
        }*/

       /* for(int n = 0; n<values.length+1; n++){
            for(int w = 0; w<W+1; w++){
                T[n][w] = 0;
            }
        }*/



        //Arrays.fill(dp, -1);
        //System.out.println(maxProfit(weights, values, W, weights.length));
        //System.out.println(topDown(weights, values, W, weights.length));
        //System.out.println(topDown_(weights, values, W, weights.length));

        System.out.println(minCoinDp(3, 6, new int[]{1, 2, 3, 4}));

    }

    public static int maxProfit(int[] weights, int[] values, int W, int n){

        if(W == 0 || n == 0)
            return 0;

        if(T[n][W] != -1)
            return  T[n][W];

        if(weights[n-1] > W){
            T[n][W] = maxProfit(weights, values, W, n - 1);
            return T[n][W];
        }else{

            T[n][W] = Math.max(values[n-1] + maxProfit(weights, values, W - weights[n-1], n - 1),
                    maxProfit(weights, values, W, n - 1));
            return T[n][W];
        }

//        if(dp[n][c] != -1)
//            return dp[n][c];
//
//        if(w[n] <= c){
//            return  dp[n][c] = Math.max( v[n] + maxProfit(w, v, c - w[n], n-1), maxProfit(w, v, c, n-1));
//        }else{
//            return  dp[n][c] = Math.max(v[n], maxProfit(w, v, c, n-1));
//        }
    }

    public static int topDown(int[] weights, int[] values, int W, int n){

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j<= W; j++){

                if(i==0 || j == 0){
                    T[i][j] = 0;
                }else if(weights[i - 1] <= j){
                    T[i][j] = Math.max(values[ i - 1] + T[i -1][j - weights[i - 1]], T[i - 1][j]);

                } else{
                    T[i][j] = T[i - 1][j];

                }
            }
        }

        return T[n][W];
    }

    public static int topDown_(int[] weights, int[] values, int W, int length){

        for(int n = 0; n <= length ; n++) {
            for(int w = 0; w<= W; w++){

                if(n == 0 || w == 0){
                    T[n][w] = 0;
                }else if(weights[n - 1] <= w){
                    T[n][w] = Math.max(values[ n - 1] + T[n -1][w - weights[n - 1]], T[n - 1][w]);
                } else{
                    T[n][w] = T[n - 1][w];
                }
            }
        }

        return T[length][W];
    }

    public static int maxProfit_(int[] weights, int[] values, int W, int n){

        if(W == 0 || n == 0 )
            return 0;

        if(weights[n-1] > W){
            return maxProfit_(weights, values, W, n - 1);
        }else{
            int left = values[n-1] + maxProfit_(weights, values, W - weights[n - 1], n - 1);
            int right = maxProfit_(weights, values, W, n - 1);

            return Math.max(left, right);
        }
    }


    public static int minCoin(int n, int sum, int[] coins){
        if(sum == 0) return 0;
        if(n == 0 && sum!=0) return -1;

        if(coins[n-1] <= sum){
            int left = minCoin(n, sum-coins[n-1], coins);
            left = left == -1 ? 0 : left;

            int right = minCoin(n-1, sum, coins);
            right = right == -1? 0: right;

            return Math.min(left, right) + 1;
        }else{
            int ans = minCoin(n-1, sum, coins);
            return ans == -1 ? 0: ans;

        }
    }

    public static int minCoinDp(int n, int sum, int[] coins){
        int[][] dp = new int[n+1][sum+1];
        for(n = 0; n <= coins.length; n++){
            for(int s = 0; s <=sum; s++){
                if(s == 0){
                    dp[n][s] = 0;
                }else if(n==0 && s!=0){
                    dp[n][s] = -1;
                }else{
                    if(coins[n-1] <= sum){
                        int left = dp[n][s-coins[n-1]];
                        left = left == -1 ? 0 : left;

                        int right = dp[n-1][s];
                        right = right == -1? 0: right;

                        dp[n][s]  = Math.min(left, right) + 1;
                    }else{
                        int ans  =  dp[n-1][s];
                        dp[n][s]  = ans == -1 ? 0: ans;
                    }
                }
            }
        }

        return dp[n][sum];
    }



}
