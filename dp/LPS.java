package dp;

public class LPS {

    public static void main(String[] args) {

        String  str = "eqvvhtcsaaqtqesvvqch";
        String reverseString = new StringBuilder().append(str).reverse().toString();
        //System.out.println(recursiveLCS(str, reverseString, str.length(), str.length()));

        longestPalindrome(str);
    }

    public static int recursiveLCS(String str1, String str2, int m, int n){

        if(m == 0 || n == 0)
            return 0;

        if(str1.charAt(m-1) == str2.charAt(n - 1)){
            return (1 + recursiveLCS(str1,str2, m - 1, n - 1));
        }else{
            return Math.max(recursiveLCS(str1,str2, m - 1, n), recursiveLCS(str1,str2, m, n - 1));
        }
    }

    public static String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int iMax = 0;
        int jMax = 0;
        int len = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                char c1 = s.charAt(i - 1);
                char c2 = s1.charAt(j - 1);
                if( c1 == c2){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(dp[i][j] > len) {
                        len = dp[i][j];
                        iMax = i;
                        jMax = j;
                    }
                }
            }
        }

        char[] ans = new char[len];
        int index = len - 1;
        StringBuilder sb1 = new StringBuilder();
        while(dp[iMax][jMax] != 0){
            ans[index] = s.charAt(iMax - 1);
            iMax--;
            jMax--;
            index--;
        }

        return String.copyValueOf(ans);
    }
}
