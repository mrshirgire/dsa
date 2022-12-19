package leetcode;

//Search in Rotated Sorted Array
public class Leetcode_33 {
    public static void main(String[] args) {

       /* int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));*/

        /*int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));*/

        int[] nums = {1, 3};
        int target = 0;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {

        int pivot = findPivot(nums);

        if(target == nums[pivot])
            return pivot;

        int start = 0;
        if(target >= nums[start] && target < nums[pivot]){
            return search( nums, target, start, pivot-1);
        }else{
            return search( nums, target,  pivot + 1, nums.length-1);
        }
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end &&  nums[mid] > nums[mid + 1]){
                return mid;
            }

            if( mid > start && nums[mid] < nums[mid - 1] ){
                return mid - 1;
            }

            if(nums[mid] <= nums[start]){
                end = mid - 1;
            }else{
                start = mid;
            }

        }

        return start;
    }

    public static int search(int[] nums, int target, int start, int end) {


        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target)
                return mid;

            if(target > nums[mid])
                start  = mid + 1;
            else
                end = mid - 1;

        }

        return -1;
    }
}
