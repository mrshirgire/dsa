package leetcode;

public class LeetCode_162 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {

        if(nums.length == 0)
            return 0;


        int start = 0;
        int end = nums.length - 1;

        while(start < end){

            if(start == end)
                return start;

            int mid = start + (end - start)/2;

            if(nums[mid] > mid + 1)
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}
