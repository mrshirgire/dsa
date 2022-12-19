import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgo {

    public static void main(String[] args) {

        //int[] arr = {4, 11, 5, 8, 10, -32, 0, -67};
        //int[] arr = {4, 3, 2, 1, 0};
        //bubbleSort(arr);
        //selectionSort(arr);
        //cyclicSort(arr);

        //.out.println(Arrays.toString(arr));
        List<Integer> list = Arrays.asList(3, 5, 2, 1, 4);
        System.out.println(quickSort(list));
    }

    public static List<Integer> quickSort(List<Integer>  arr){

        if(arr.size() <= 1)
            return arr;

        int pivot = arr.get(0);

        List<Integer> smallest = new ArrayList<>();
        List<Integer> greatest = new ArrayList<>();

        for(int i = 1; i< arr.size(); i++){
            if(arr.get(i) <= pivot)
                smallest.add(arr.get(i));
            else
                greatest.add(arr.get(i));
        }

        List<Integer> ans = new ArrayList<>();

        ans.addAll(quickSort(smallest));
        ans.add(pivot);
        ans.addAll(quickSort(greatest));
        return ans;

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
