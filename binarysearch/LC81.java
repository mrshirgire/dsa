package binarysearch;

public class LC81 {

    public static boolean search(int[] nums, int target) {

        int pivot = findPivot(nums);
        if(search(nums, 0, pivot, target))
            return true;
        else{
            return search(nums,pivot + 1, nums.length - 1, target);
        }
    }

    static boolean search(int[] arr, int start, int end, int target){

        while(start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] == target) return true;

            if(target > arr[mid]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        return false;
    }


    static int findPivot(int[] nums){

        int n = nums.length;
        int start = 0;
        int end = nums.length -1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if( mid < end && nums[mid] > nums[mid + 1]) return mid;
            if( mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            if(nums[start] >= nums[mid]){
                end  = mid -1;
            }else if(nums[start] <= nums[mid]) {
                start  = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
