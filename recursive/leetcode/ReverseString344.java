package recursive.leetcode;

public class ReverseString344 {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s, int start, int end){

        if(start>=end) return;

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverseString(s, start + 1, end - 1);

    }
}
