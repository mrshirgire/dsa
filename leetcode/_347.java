package leetcode;

import java.util.*;

class _347 {


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       
       for(int i = 0; i< nums.length; i++){
            
           
           int key = nums[i];
           if(map.containsKey(key)){
                map.replace(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
       }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {

			public int compare(Map.Entry<Integer,Integer> obj1,Map.Entry<Integer,Integer> obj2){
				//return  obj1.getValue().compareTo(obj2.getValue());
				//sorting in descending order
				return  obj2.getValue().compareTo(obj1.getValue());
			}
		});

		Map<Integer,Integer> sortedMap = new LinkedHashMap<>();

		for(Map.Entry<Integer,Integer> entry :list ){
			sortedMap.put(entry.getKey(),entry.getValue());
		}
        
        
        
       int[] ans = new int[k];

       Iterator<Map.Entry<Integer, Integer>> ite = sortedMap.entrySet().iterator();
       for(int i = 0; i < k; i++){
           if(ite.hasNext()){
               ans[i] = ite.next().getKey();
           }
       }

       return ans ;
    }
}