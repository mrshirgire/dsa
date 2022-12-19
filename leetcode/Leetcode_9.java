package leetcode;

public class Leetcode_9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {

        if(x < 0) return false;
        if(x % 10 == x) return true;



        int ans = 0;
        int num = x;
        while(num != 0){
            ans = ans * 10 + num % 10;
            num = num/10;
        }

        return x == ans;
    }
}

