package leetcode;

public class LeetCode_441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(3));
    }

    public static int arrangeCoins(int n) {

        int row = 1;
        while(row <= n){
            row++;
            n = n - row + 1;
        }

        return row - 1;
    }
}
