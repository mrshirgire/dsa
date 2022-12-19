import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {

//        int[] nums = {1, 3, 5, 3, 7, 9, 10, 4};
//        System.out.println(maxSum1(nums, 3));
//        System.out.println(maxSum2(nums, 3));

        System.out.println(anagramCount("aabaabaa", "aaba"));


        //int[] nums = {12, -1, -7, 8, 15, 10, 16, 28};
        //System.out.println((firstNegative(nums, 3)));
        //System.out.println(maxNumber(nums, 3));

        //int[] nums = { 3, 1, 1, 4, 2, 1, 1, 1, 1, 2, 3};
        //System.out.println(largestWindowSizeSum(nums,5));

        //System.out.println(largestSubStringWithKUniqueChar("aabcehffffggggkkkk", 3));
        //System.out.println(largestSubStringWithNonRepetitiveChar("nfpdmpi"));


    }

    private static int anagramCount(String s, String s1){
        int count = 0;

        int i=0, j=0;

        Map<Character, Integer> map = new HashMap<>();
        for(int k=0; k<s1.length(); k++){


            int cnt = map.containsKey(s.charAt(k)) ? map.get(s.charAt(k)) + 1: 1;
            map.put(s.charAt(k), cnt);
        }

        while (j<s.length()){

            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            }

            if(j - i + 1 < s1.length()) j++;
            else if(j - i + 1 == s1.length()){

                boolean flag = true;

                Set<Map.Entry<Character, Integer>> set  = map.entrySet();
                for(Map.Entry entry : set){
                    if((int)entry.getValue() > 0){
                        flag = false;
                        break;
                    }
                }

                count = flag == true ? count + 1: count;


                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                }

                i++; j++;
            }
        }

        return count;
    }

    private static int maxSum1(int[] nums, int windowSize) {

        int maxSum = 0;
        int sum = 0;
        for(int i=0; i <= nums.length-windowSize; i++){
            if(i==0){
                for(int j=0; j<windowSize; j++)
                    sum += nums[j];
            }else
                sum += nums[i + windowSize - 1] - nums[i-1];

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    private static int maxSum2(int[] nums, int windowSize) {

        int i=0;
        int j=0;
        int maxSum = 0;
        int sum = 0;
        while(j< nums.length){

            sum += nums[j];
            if((j - i + 1) < windowSize){
                j++;
            }else if((j - i + 1) == windowSize){
                maxSum = Math.max(sum, maxSum);
                sum = sum - nums[i];
                i++;j++;
            }
        }

        return maxSum;
    }

    private  static  Vector<Integer> maxNumber(int[] nums, int windowSize){

        Vector<Integer> maxNumbers = new Vector<>();
        Queue<Integer> q = new LinkedList<>();
        int i=0, j=0;
        while(j< nums.length) {
            int qSize = q.size();
            for (int qIndex = 0; qIndex < qSize; qIndex++) {
                if (q.peek() < nums[j])
                    q.remove();
            }

            q.add(nums[j]);

            if (j - i + 1 < windowSize) {
                j++;
                continue;
            } else if (j - i + 1 == windowSize) {
                maxNumbers.add(q.peek());
                if (nums[i] == q.peek())
                    q.remove();
                i++;
                j++;
            }
        }

        return  maxNumbers;

    }

    private static List<Integer> firstNegative(int[] nums, int windowSize){

        /* Brute force solution*/
        /*

        int ansSize = nums.length - windowSize + 1;
        int[] ans = new int[ansSize];

        for(int i = 0; i <= nums.length-windowSize; i++){
            for(int j = i; j < (i + windowSize); j++){
                if(nums[j]<0 && ans[i] == 0){
                    ans[i] = nums[j];
                }
            }
        }

        return ans;*/


        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(j< nums.length){

            if (nums[j] < 0 ) q.add(nums[j]);

            if(j - i + 1 < windowSize) j++;
            else if(j - i + 1 == windowSize){

                int val = q.isEmpty() ? 0 : q.peek();
                ans.add(val);

                if(!q.isEmpty() && q.peek() == nums[i]) q.remove();
                i++;j++;
            }
        }

        return ans;

        /*int ansSize = nums.length - windowSize + 1;
        int[] ans = new int[ansSize];

        int i=0, j=0;

        Vector vector = new Vector();
        int listIndex = -1;
        while(j< nums.length){

            if(nums[j] < 0 ){
                vector.add(nums[j]);
            }

            if((j - i + 1) < windowSize){
                j++;
                continue;
            }else if((j - i + 1 ) == windowSize){
                if(vector.size() == 0)
                    ans[i] = 0;
                else
                    ans[i] = (int) vector.get(0);
            }

            j++; i++;
        }

        return ans;*/
    }

    private static int largestWindowSizeSum(int[] nums, int k){

        int maxSize =0, i = 0, j = 0;
        long sum = 0;
        while (j < nums.length) {
            sum += nums[j];

            if (sum < k) {
                j++;
                continue;
            } else if (sum == k) {
                maxSize = Math.max(maxSize, j-i+1);
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }


        return maxSize;
    }

    private  static int largestSubStringWithKUniqueChar(String s, int k){

        int i = 0, j =0;
        int max = 0 ;
        Map<Character, Integer> map = new LinkedHashMap<>();
        while (j < s.length()){

            Character c = s.charAt(j);
            if (map.get(c) == null) map.put(c,1);
            else map.put(c, map.get(c) + 1);

            if(map.size() < k) {
                j++;
            }else if (map.size() ==  k){
                max = j - i + 1;
                j++;
            }else if(map.size() > k){

                while (map.size() > k){

                    Character c1 = s.charAt(i);
                    int charCount = map.get(c1);
                    map.put(c1, charCount - 1 );
                    if (--charCount == 0) map.remove(c1);
                    i++;
                }
                j++;
            }
        }

        return max;
    }

    public static int largestSubStringWithNonRepetitiveChar(String s){

        int i = 0, j =0;
        int max = 0 ;
        Map<Character, Integer> map = new LinkedHashMap<>();
        while (j < s.length()){

            Character c = s.charAt(j);
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);

            int windowSize = j - i + 1;
            if (map.size() == windowSize){
                max = Math.max(max,windowSize);
            }else {
                while(map.size() < j - i + 1){
                    Character c1 = s.charAt(i);

                    if (map.get(c1) - 1 == 0)
                        map.remove(c1);
                    else
                        map.put(c1, map.get(c1) - 1);

                    i++;
                }
            }

            j++;

        }

        return max;
    }

}
