package leetcode;

import java.util.*;

public class LeetCode_1048 {


    public static String[] words_ = {"a","b","ba","bca","bda","bdca"};
    public static Set<String> words = new HashSet<>();
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        Collections.addAll(words, words_);

        int ans = 0;
        for(String word: words){
            int maxLen = longestChain(word);
            ans = Math.max(ans, maxLen);
        }

    }


    public static int longestChain(String  str){

        if(str.length() <= 0) return 0;

        if(map.containsKey(str))
            return map.get(str);

        StringBuilder stringBuilder = new StringBuilder(str);
        int localMaxLen = 1;

        for(int i =0; i<stringBuilder.length(); i++){
            stringBuilder.deleteCharAt(i);
            String newWorld = stringBuilder.toString();
            if(words.contains(newWorld)){
                int currLen = 1 + longestChain(newWorld);
                localMaxLen = Math.max(localMaxLen, currLen);
            }

            stringBuilder.insert(i, stringBuilder.charAt(i));
        }

        map.put(str, localMaxLen);
        return localMaxLen;

    }
}
