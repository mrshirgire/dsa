package recursive;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};

        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
    }


    public static int[] mergeSort(int arr[], int start, int end){

        if(start == end){
            int [] list = {arr[start]};
            return list;
        }

        int m = start + (end - start)/2;

        return merge(mergeSort(arr, start, m), mergeSort(arr, m+ 1, end));
    }

    public static int[] merge(int[] arr1 , int[] arr2){

        int[] ans = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                ans[k] = arr1[i];
                i++;
            }else{
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length){
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length){
            ans[k] = arr2[j];
            j++;
            k++;
        }

        return ans;
    }
}
