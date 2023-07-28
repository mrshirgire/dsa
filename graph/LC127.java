package graph;

import java.util.List;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        for(int i = 0; i < beginWord.length(); i++){

            for(char c = 'a'; c <= 'z'; c++){

                String str = c + beginWord.substring(i, i+ 1);

            }
        }

        return 0;
    }
}
