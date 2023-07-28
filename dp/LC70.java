package dp;

public class LC70 {

    int[] dp;
    public int climbStairs(int n) {

        dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <=n; i++){
            int left = dp[i - 1];
            int right = i > 1 ? dp[i - 2] : 0;
            dp[i] = left + right;
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(new LC70().climbStairs(2));
    }
}
