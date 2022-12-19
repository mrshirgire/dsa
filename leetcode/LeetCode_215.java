package leetcode;

public class LeetCode_215 {
    //public static int[] arr;
    public static int findKthLargest(int[] nums, int k) {


        for(int i = nums.length/2; i>0; i--){
            nums = hipify(nums, i, nums.length);
        }

        nums = remove(nums, k-1);

        return nums[0];
    }

    public static int[] hipify(int[] arr, int currIndex, int length){

        int maxIndex = currIndex;
        int leftIndex = 2 * currIndex;
        int rightIndex = 2 * currIndex + 1;

        if(leftIndex <= length && arr[leftIndex-1] > arr[maxIndex-1]){
            maxIndex = leftIndex;
        }

        if(rightIndex<=length && arr[rightIndex-1] > arr[maxIndex-1]){
            maxIndex = rightIndex;
        }

        if(maxIndex != currIndex){
            arr = swap(arr, maxIndex-1, currIndex-1);
            return hipify(arr, maxIndex, length);
        }

        return arr;
    }



    public static int[] swap(int[] maxHeap, int parentIndex, int j) {

        int temp = maxHeap[parentIndex];
        maxHeap[parentIndex] = maxHeap[j];
        maxHeap[j] = temp;

        return maxHeap;
    }

    private static int[] remove(int[] heap, int noOfElementsToRemove){

        int len = heap.length;
        for(int i = 0; i < noOfElementsToRemove; i++){

            len--;
            heap = swap(heap, 0, len);

            for(int j = len/2; j>0; j--){
                heap = hipify(heap, j, len);
            }
        }

        return heap;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        /*int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;*/

        System.out.println(findKthLargest(nums, k));
    }
}
