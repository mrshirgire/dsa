package dp;

public class LCS {
    static String str1 = "abedgh";
    static String str2 =  "abedfhr";
    static int[][] T = new int[str1.length() + 1][str2.length() + 1];



    public static void main(String[] args) {
        for(int i = 0; i<=str1.length(); i++){
            for(int j = 0; j<=str2.length(); j++){
                T[i][j] = -1;
            }
        }

        System.out.println(LCS(str1,str2, str1.length(), str2.length()));
    }


    public static int LCS(String str1, String str2, int m, int n){

        if(n==0 || m == 0)
            return 0;

        if(T[m][n] != -1)
            return T[m][n];

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return T[m][n] = 1 + LCS(str1, str2, m - 1, n - 1);
        }else{
            return T[m][n] = Math.max(
                    LCS(str1, str2, m, n -1),
                    LCS(str1, str2, m - 1, n)
            );
        }
    }
}
