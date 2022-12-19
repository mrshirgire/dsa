package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode_528 {


    public static int[] accuSumList;
    public static int accuSum = 0;
    public static void main(String[] args) {
        int[] w = {3,14,1,7};
        new LeetCode_528(w);
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());
        System.out.println(pickIndex());

    }

    public LeetCode_528(int[] w) {

        accuSumList = new int[w.length];

        for(int i = 0; i < w.length; i++){
            accuSum = accuSum + w[i];
            accuSumList[i] = accuSum;
        }
    }

    public static int pickIndex() {
        Random random = new Random();
        int randomNum = random.nextInt() % accuSum;
        if(randomNum<0)
            randomNum = randomNum * -1;
        return search(randomNum);

    }

    public static int search(int target){

        if(accuSumList.length == 0)
            return 0;

        int start = 0;
        int end = accuSumList.length - 1;

        while (start<=end){
            int mid = start + (end - start)/2;
            if(target == accuSumList[mid])
                return mid;

            if(target > accuSumList[mid]){
                start = mid + 1;
            }else{
                end = end - 1;
            }
        }

        return start;

    }
}
