package recursive;

import java.util.Arrays;

public class RecursionExamples {

    public static void main(String[] args) {
        int[] arr =  {4, 3, 9, 5, 6, 2, 2};
        bubbleSort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
        int[] arr1 =  {4, 3, 9, 5, 6, 2, 2};
        selectionSort(arr1, arr.length - 1,0, 0 );
        System.out.println(Arrays.toString(arr1));
    }


    public static void bubbleSort(int[] arr, int i, int j){

        if(i == 0) return;

        if( j < i) {
            if (arr[j] > arr[j+1]){
               //swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSort(arr, i, j + 1 );
        }else{
            bubbleSort(arr, i - 1, 0);
        }
    }

    public static void selectionSort(int[] arr, int i, int j, int maxIndex){

        if(i == 0) return;

        if(j < i) {
            maxIndex = arr[j] > arr[maxIndex]? j : maxIndex;
            selectionSort(arr, i, j + 1, maxIndex);
        } else {

            if(maxIndex != i){
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }

            selectionSort(arr,i - 1, 0, 0);
        }
    }


}
