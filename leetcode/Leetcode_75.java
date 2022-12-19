package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Leetcode_75 {
    public static void main(String[] args) {
        int[] arr = new int[] {2,0,2,1,1,0};
        sortColors(arr);
    }

    public static void sortColors(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        map.forEach((key,value)->{

            for(int j=0;j<value;j++){
                list.add(key);
            }
        });

        System.out.println(list);
    }
}
