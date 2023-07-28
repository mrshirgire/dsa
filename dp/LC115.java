package dp;

public class LC115 {

    public static void main(String[] args) {
        String str1 = "babgbag";
        String str2 = "bag";
        numDistinct(str1, str2);
    }
    public static int numDistinct(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();


        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= m; j++){
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if(c1 == c2){
                     dp[i][j] = dp[i - 1][j - 1] +  dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];

        //return fun(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    static int fun(String str1, String str2, int i, int j){

        if( j < 0) return 1;
        if(i < 0) return 0;

        char c1 = str1.charAt(i);
        char c2 = str2.charAt(j);
        if(c1 == c2){
            return fun(str1, str2, i - 1, j - 1) +  fun(str1, str2, i - 1, j);
        }else{
            return fun(str1, str2, i - 1, j);
        }

    }
}
