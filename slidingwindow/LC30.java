package slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC30 {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        int n = s.length();
        int wordLength = words[0].length();
        int startIndex = i;
        Set<String> set = new HashSet<>();
        for(String word: words) set.add(word);
        while(j < n - 3){
            String subString = s.substring(j, j+3);
            if(isContains(subString, set)){
                if(set.size() == 0){
                    ans.add(startIndex);
                    initSet(set,words);
                }
                j = j + wordLength;
            }else{
                j = i + 3;
                startIndex = j;
                initSet(set,words);
            }
        }

        return ans;
    }

    static void initSet(Set<String> set, String[] words){
        for(String word: words)
            set.add(word);
    }


    static boolean isContains(String str, Set<String> set){

        if(set.contains(str)){
            set.remove(str);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
      /*  String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};*/

        /*String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};*/

        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};

        List<Integer> ans =  findSubstring(s, words);
        System.out.println(ans);
    }
}
