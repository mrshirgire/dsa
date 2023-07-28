package dp;

public class LC_2193 {

    static String str1 = "eqvvhtcsaaqtqesvvqch";
    static int[][] T = new int[str1.length() + 1][str1.length() + 1];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(str1);
        String str2 = sb.reverse().toString();
        printLCS(str1, str2);
    }

//    public static int minMovesToMakePalindrome(String s) {
//
//        StringBuilder sb = new StringBuilder(s);
//        String s1 = sb.reverse().toString();
//        int n = s.length();
//        int[] prev = new int[n + 1];
//
//        for(int i = 1; i <= n; i++){
//            int[] curr = new int[n + 1];
//            for(int j = 1; j <=n; j++){
//                if(s.charAt(i - 1) == s1.charAt(j - 1)){
//                    curr[j] = 1 + prev[j - 1];
//                }else{
//                    curr[j] = Math.max(prev[j], curr[j - 1]);
//                }
//            }
//            prev = curr;
//        }
//
//        String palindromString = longestPalindrome(s);
//
//        int lcpLen = prev[n];
//        int noOfElementsToBeMove = n - lcpLen;
//        int moves = 0;
//        while(noOfElementsToBeMove != 0 ){
//
//            moves+= lcpLen/2;
//            lcpLen++;
//            noOfElementsToBeMove--;
//        }
//
//        return moves;
//
//    }

    public static void printLCS(String str1, String str2){

        int m = str1.length();
        int n = str2.length();
        StringBuilder stringBuilder = new StringBuilder();

        longestCommonSubSequence(str1, str2, m, n);

        while( m>0 || n>0){

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
}
