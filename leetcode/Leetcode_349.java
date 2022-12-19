package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode_349 {
    public static void main(String[] args) {
       // int[] arr1 = {1,2,2,1}, arr2 = {2,2};
        int[] arr1 = {4,9,5}, arr2 = {9,4,9,8,4};

        System.out.println(Arrays.toString(intersection(arr1, arr2)));

    }

    public static int[] intersection(int[] arr1, int[] arr2) {

        if(arr1.length < arr2.length)
            return arraysIntersection(arr1, arr2);
        else
            return arraysIntersection(arr2, arr1);
    }

    public static int[] arraysIntersection(int[] smallestArr, int[] largestArr){

        Arrays.sort(smallestArr);
        Arrays.sort(largestArr);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<smallestArr.length; i++){
            if(isPresent(largestArr, smallestArr[i]) && !ans.contains(smallestArr[i])){
                ans.add(smallestArr[i]);
            }
         }

        return ans.stream().mapToInt(i->i).toArray();

    }

    private static boolean isPresent(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if (target == arr[mid])
                return true;
            else if(target > arr[mid])
                start = mid +1;
            else
                end = mid - 1;
        }

        return false;
    }
}
