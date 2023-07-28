package sorting;

import java.util.Arrays;

public class MergeSort {

    int[] sort(int[] nums){

        if(nums.length == 1) return nums;

        int start = 0;
        int end = nums.length -1;

        int mid  = start + (end - start)/2;
        int[] leftArr = Arrays.copyOfRange(nums, start, mid+1);
        int[] rightArr = Arrays.copyOfRange(nums, mid+1, nums.length);
        int[] left = sort(leftArr);
        int[] right = sort(rightArr);

        int[] mergeArr = merge(left, right);

        return mergeArr;

    }

    int[] merge(int[] left, int[] right){

        int[] ans = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){

            if(left[i] < right[j]){
                ans[k] = left[i];
                i++;
            }else{
                ans[k] = right[j];
                j++;
            }

            k++;
        }


        while(i < left.length){
            ans[k]  = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        int[] nums = new int[] {1,2,5,2,3};
        int[] ans = mergeSort.sort(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(ans[i]+" ");

    }
}
