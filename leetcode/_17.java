package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _17 {

    public static void main(String[] args) {

        System.out.println(f("abc", "def"));

        //System.out.println(letterCombination("", "abc", ""));
    }

    public static List<String> f(String str1, String str2){

        List<String> list = new ArrayList<>();

        for(int i =0; i < str1.length(); i++){
            char c = str1.charAt(i);
            for(int j = 0; j< str2.length();j++){
                list.add( Character.toString(c) + str2.charAt(j));
            }
        }

        return list;
    }


    //recursive approved
    public static List<String> letterCombination(String processed, String str1,String str2){

        if(str1.isEmpty() || processed.length() == 2){

            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < str1.length(); i++) {

            char c = str1.charAt(i);


            for(int j = 0; j < str2.length(); j++) {
                List<String> ans_ = letterCombination(Character.toString(c) + str2.charAt(j), str1.substring(1), str2);
                ans.addAll(ans_);
            }
        }

        return ans;

    }


}
