package dp;

import java.util.Arrays;

public class Knapsack {

    static int[][] T = new int[4][11];

    public static void main(String[] args) {
        int[] weights = {5, 2, 6};
        int[] values = {1000, 200, 600};
        int W = 10;


        for(int i=0;i<4; i++){
            for(int j=0;j<11; j++){
                T[i][j] = -1;
            }
        }
        //Arrays.fill(dp, -1);
        //System.out.println(maxProfit(weights, values, W, weights.length));
        System.out.println(topDown(weights, values, W, weights.length));
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
}
