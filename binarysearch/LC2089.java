package binarysearch;

import sorting.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2089 {

    public List<Integer> targetIndices(int[] nums, int target) {

        int[] sortedArr = sort(nums);
        int startIndex = findStartIndex(sortedArr, target);
        List<Integer> ans = new ArrayList<>();

        while(startIndex < nums.length && sortedArr[startIndex] == target){
            ans.add(startIndex);
            startIndex++;
        }

        return ans;
    }

    int findStartIndex(int[] arr, int target){

        int start = 0;
        int end = arr.length -1;
        while(start < end){

            int mid = start + (end - start)/2;
            if(target > arr[mid]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

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

        LC2089 lc2089 = new LC2089();

        int[] nums = new int[] {1,2,5,2,3};
        List<Integer> ans = lc2089.targetIndices(nums, 5);
        System.out.print(ans);
    }
}
