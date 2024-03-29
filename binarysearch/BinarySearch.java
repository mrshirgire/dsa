package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 8, 10};
        System.out.println(search(arr, 67));

    }

    public static int search(int[] arr, int target){

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(target == arr[mid]){
                return mid;
            }

            if(target > arr[mid])
                start = mid + 1;
            if(target < arr[mid])
                end = mid - 1;
        }

        return -1;
    }
}
