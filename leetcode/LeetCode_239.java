package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_239 {

    public static void main(String[] args) {

        //int[] nums = {1,3,1,2,0,5};
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        //int[] nums = {1,3,1,2,0,5}; //expected [3,3,2,5]
        int[] nums = {-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}; //expected [-6, -1, -1, 9, 9, 9, 10, 10, 10, 9, 9, 9, 7, 7, 7, 4, 8, 8]
        int[] ans  = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0;
        int j = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k +1];

        while(j<nums.length) {

            int element = nums[j];
            while(!deque.isEmpty() && deque.peekLast() < element) {
                deque.pollLast();
            }
            deque.offer(element);

            if(j - i + 1 < k){
                j++;
            }else if( j - i + 1 == k) {

                ans[i] = deque.getFirst();

                if(ans[i] == nums[i])
                    deque.remove();

                i++;
                j++;
            }
        }

        return ans;
    }
}
