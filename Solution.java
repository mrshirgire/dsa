public class Solution {

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("abcabasdg"));
        int[] nums1 = {2}, nums2 = {};
        System.out.println(findMedianOfSortedArrays(nums1, nums2));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private static boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }


    public static double findMedianOfSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, j=0, k = 0;
        double[] sortedArray = new double[nums1.length + nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                sortedArray[k] = nums1[i];
                i++;k++;
            }else{
                sortedArray[k] = nums2[j];
                j++;k++;
            }
        }

        if(i < nums1.length) {
            while(i < nums1.length){
                sortedArray[k] = nums1[i];
                i++;k++;
            }
        }else if(j < nums2.length){
            while(j < nums2.length){
                sortedArray[k] = nums2[j];
                j++;k++;
            }
        }


        double m = 0;
        int n = sortedArray.length;
        if(n%2==1)	{
            m=sortedArray[(n+1)/2-1];
        }else {
            m=(sortedArray[n/2-1]+sortedArray[n/2])/2;
        }

        return m;

    }
}