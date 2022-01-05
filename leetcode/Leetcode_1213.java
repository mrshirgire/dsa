package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_1213 {

    public static void main(String[] args) {
        //int [] arr1 = {1,2,3,4,5}, arr2 = {1,2,5,7,9}, arr3 = {1,3,4,5,8};
        //int [] arr1 = {197,418,523,876,1356}, arr2 = {501,880,1593,1710,1870}, arr3 = {521,682,1337,1395,1764};
        int [] arr1 = {17,193,281,421,523,596,1484,1803,1853,1863}, arr2 = {381,770,1100,1164,1211,1483,1486,1639,1908,1988}, arr3 = {107,290,291,546,751,896,967,1532,1538,1784};

        System.out.println(arraysIntersection(arr1, arr2, arr3));

    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        int smallestIndex = smallestArray(arr1, arr2, arr3);

        switch (smallestIndex){
            case 0:
                return arraysIntersection_(arr1, arr2, arr3);
            case 1:
                return arraysIntersection_(arr2, arr1, arr3);
            default:
                return arraysIntersection_(arr3, arr1, arr2);
        }


    }

    public static List<Integer> arraysIntersection_(int[] arr1, int[] arr2, int[] arr3){

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<arr1.length; i++){
            boolean isPresentInArr2 = isPresent(arr2, arr1[i]);
            boolean isPresentInArr3 = isPresent(arr3, arr1[i]);

            if(isPresentInArr2 && isPresentInArr3)
                ans.add(arr1[i]);
        }

        return ans;
    }

    private static int smallestArray(int[] arr1, int[] arr2, int[] arr3) {
        if(arr1.length < arr2.length && arr1.length < arr3.length){
            return 0;
        }else if(arr2.length < arr1.length && arr2.length < arr3.length){
            return 1;
        }else{
            return 2;
        }
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
