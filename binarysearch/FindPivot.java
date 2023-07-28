package binarysearch;

public class FindPivot {

    static int findPivot(int[] arr){

        if(arr.length == 1) return arr[0];

        int start = 0;
        int end = arr.length -1;
        while(start <= end){

            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1]) return mid;
            if(arr[mid] < arr[mid -1]) return mid -1;

            if(arr[start] >= arr[mid]) end  = mid -1;
            if(arr[start] <= arr[mid]) start  = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(findPivot(arr));

    }
}
