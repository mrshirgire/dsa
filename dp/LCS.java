package dp;

public class LCS {
    static String str1 = "eqvvhtcsaaqtqesvvqch";
    static String str2 =  "eqvvhtcsaaqtqesvvqch";
    static int[][] T = new int[str1.length() + 1][str2.length() + 1];



    public static void main(String[] args) {

        for(int i = 0; i<=str1.length(); i++){
            for(int j = 0; j<=str2.length(); j++){
                T[i][j] = -1;
            }
        }

        String reverseString = new StringBuilder().append(str1).reverse().toString();
        //System.out.println(recursiveLCS(str1, str2, str1.length(), str2.length()));
        //System.out.println(LCS(str1,str2, str1.length(), str2.length()));
        printLCS(str1, reverseString);
    }

    // longestCommonSubSequence with recursion
    public static int recursiveLCS(String str1, String str2, int m, int n){

        if(m == 0 || n == 0)
            return 0;

        if(str1.charAt(m-1) == str2.charAt(n - 1)){
            return (1 + recursiveLCS(str1,str2, m - 1, n - 1));
        }

        return Math.max(recursiveLCS(str1,str2, m - 1, n), recursiveLCS(str1,str2, m, n - 1));
    }


    // longestCommonSubSequence with memorization
    public static int longestCommonSubSequence(String str1, String str2, int m, int n){

        if(n==0 || m == 0)
            return 0;

        if(T[m][n] != -1)
            return T[m][n];

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return T[m][n] = 1 + longestCommonSubSequence(str1, str2, m - 1, n - 1);
        }else{
            return T[m][n] = Math.max(
                    longestCommonSubSequence(str1, str2, m, n -1),
                    longestCommonSubSequence(str1, str2, m - 1, n)
            );
        }
    }


    public static int LCS(String text1, String text2){

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 0; i <= text1.length(); i++){
            for(int j = 0; j <= text2.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                         dp[i][j] = 1 + dp[i - 1][j - 1];
                    }else{
                         dp[i][j] = Math.max( dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[text1.length() + 1][text2.length() + 1];
    }

    public static int longestCommonSubString(String str1, String str2){

        int str1Len = str1.length();
        int str2Len = str2.length();
        int[][] dp = new int[str1Len + 1][ str2Len + 1];

        for(int i = 0; i <=str1Len; i++){
            for(int j = 0; j< str2Len; j++){
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }else{
                    char c1 = str1.charAt(i-1);
                    char c2 = str2.charAt(j -1);
                    if(c1 == c2){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return dp[str1Len][str2Len];
    }


    public static void printLCS(String str1, String str2){

        int m = str1.length();
        int n = str2.length();
        StringBuilder stringBuilder = new StringBuilder();

        longestCommonSubSequence(str1, str2, m, n);

        while( m>0 && n>0){

            char c1 = str1.charAt(m-1);
            char c2 = str2.charAt(n-1);
            if(c1 == c2){
                stringBuilder.append(c1);
                n--;
                m--;
            }else{
                if(T[m][n-1]>T[m-1][n]){
                    n--;
                }else{
                    m--;
                }
            }
        }

        System.out.println(stringBuilder.reverse());
    }

    public static int LPS(String str1){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        String str2 = stringBuilder.reverse().toString();

        int len = longestCommonSubSequence(str1,str2, str1.length(), str2.length());

        return len;
    }

    public static int minDeletionToMakePalindrome(String str){

        return str.length() - LPS(str);
    }

}
