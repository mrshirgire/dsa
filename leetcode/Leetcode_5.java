package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {

        int maxLength = Integer.MIN_VALUE;
        String ans = "";

        List<String> list = generate(s, new ArrayList<>());

        for(int i = 0; i< s.length(); i++){
            for(int j = i; j <s.length(); j++){

                String subString = s.substring(i, j + 1);
                if(isPalindrome(subString)) {
                    int palindromeLength = subString.length();
                    if( palindromeLength > maxLength){
                        maxLength = palindromeLength;
                        ans = subString;
                    }
                }
            }
        }

        return ans;

    }



    public static boolean isPalindrome(String str){

        StringBuffer stringBuffer = new StringBuffer(str);
        return str.equals(String.valueOf(stringBuffer.reverse()));
    }

    public static List<String> generate(String word, List<String> list) {

        if (word.length() == 1) {
            list.add(word);
            return list;
        }else{

            list.add(word);
            generate(word.substring(0, word.length()-1), list);
            generate(word.substring(1, word.length()), list);
        }

        return list;
    }
}
