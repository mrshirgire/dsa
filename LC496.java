public class LC496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans  = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            int index = findIndex(nums2, num);

            for(int j = index + 1; j < nums2.length; j++){
                if(nums2[j] > num){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        for(int i = 0; i < nums1.length; i++){
            if(ans[i] == 0) ans[i] = -1;
        }

        return ans;
    }


    static int findIndex(int[] nums2, int target){

        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] == target) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = nextGreaterElement(nums1,nums2);
        System.out.println(ans);
    }
}
