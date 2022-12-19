package dp;

public class LPS {

    public static void main(String[] args) {

        String  str = "agbcba";
        String reverseString = new StringBuilder().append(str).reverse().toString();
        System.out.println(recursiveLCS(str, reverseString, str.length(), str.length()));

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
}
