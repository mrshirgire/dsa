import java.util.Arrays;

public class SortingAlgo {

    public static void main(String[] args) {

        //int[] arr = {4, 11, 5, 8, 10, -32, 0, -67};
        int[] arr = {4, 3, 2, 1, 0};
        //bubbleSort(arr);
        //selectionSort(arr);
        cyclicSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){

        for(int pass = 0; pass < arr.length; pass++){

            int last = arr.length - pass - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, last, maxIndex);
        }
    }

    public static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for(int i = start+1; i<=end; i++){
            if (arr[i] > arr[max]) {
                max = i;
            }
        }

        return max;
    }


    private static void bubbleSort(int[] arr) {

        boolean swapped;
        for(int pass = 1; pass < arr.length; pass++){
            swapped = false;
            for(int j=1; j < arr.length; j++){
                if(arr[j]<arr[j-1]){
                    //swap
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;

                    swapped =true;
                }
            }

            if(!swapped)
                break;
        }
    }

    private static void cyclicSort(int[] arr) {

        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i];
            if(arr[i] != i){
                swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }
    }


    private static void swap(int[] nums, int last, int maxIndex) {
        int temp = nums[last];
        nums[last] = nums[maxIndex];
        nums[maxIndex] = temp;
    }
}
