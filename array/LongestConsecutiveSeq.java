package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int longest = 0;
        for(Integer el: set){

            if(set.contains(el - 1))
                continue;

            int num = el;
            int cnt = 1;
            while(set.contains(num + 1)){
                cnt++;
                num = num + 1;
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
