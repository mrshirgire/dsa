package recursive.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CircularGameWinner1823 {



    public static void main(String[] args) {

        int noOfPlayers = 6;
        int k = 5;
        int startPlayerIndex = 0;
        boolean[] removedItem = new boolean[noOfPlayers];
        for(int i = 0; i< noOfPlayers; i++){
            removedItem[i] = false;
        }
        System.out.println(findTheWinner(noOfPlayers - 1, k, startPlayerIndex, removedItem));
        ;
    }

    public static int findTheWinner(int noOfPlayers, int k, int startPlayerIndex, boolean[] removedItem) {

        if(noOfPlayers == 0)
            return startPlayerIndex + 1;

        int removeIndex = (startPlayerIndex + k - 1) % removedItem.length;
        removeIndex = (removeIndex + removedItem.length) % removedItem.length;


//        for(int i = removeIndex; i< removedItem.length;){
//            removeIndex = ((removeIndex + removedItem.length) % removedItem.length) + 1;
//        }

        while (removedItem[removeIndex]){
            removeIndex++;
            removeIndex = (removeIndex + removedItem.length) % removedItem.length;
        }

        removedItem[removeIndex] = true;
        startPlayerIndex = (removeIndex + 1) % removedItem.length;
        while(removedItem[startPlayerIndex])
            startPlayerIndex++;

        return findTheWinner(--noOfPlayers, k, startPlayerIndex, removedItem);


    }


}
