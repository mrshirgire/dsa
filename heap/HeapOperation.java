package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapOperation {

    public static int[] maxHeap;

    public static void createMaxHeap(int[] arr){

        maxHeap = new int[arr.length];
        int parentIndex = 0;
        int i = 0;
        while(i < arr.length){

            if(i == 0){
                maxHeap[i] = arr[i];
                i++;
            }else{

                int leftIndex = 2 * parentIndex + 1;
                int rightIndex = 2 * parentIndex + 2;

                maxHeap[leftIndex] = arr[i];
                int pIndex = parentIndex;
                while (pIndex >=0 && maxHeap[pIndex] < maxHeap[leftIndex]){
                    swap(maxHeap, pIndex, leftIndex);
                    leftIndex = pIndex;
                    if(parentIndex == 1){
                        pIndex--;
                    }else{
                        pIndex = pIndex -2;
                    }

                }

                maxHeap[rightIndex] = arr[i + 1];
                pIndex = parentIndex;
                while (pIndex >=0 && maxHeap[pIndex] < maxHeap[rightIndex]){
                    swap(maxHeap, pIndex, rightIndex);
                    rightIndex = pIndex;
                    if(parentIndex == 1){
                        pIndex--;
                    }else{
                        pIndex = pIndex -2;
                    }
                }

                parentIndex++;
                i = i + 2;
            }
        }

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



    private static void checkAndSwap(int[] arr, int startIndex, int endIndex) {

        while(endIndex>=startIndex){
            int parentIndex = endIndex % 2 == 1 ? (arr.length - 1) / 2 : ((arr.length - 1) / 2) - 1;
            if(arr[endIndex] > arr[parentIndex]){
                swap(arr, parentIndex, endIndex);
            }
            endIndex--;
        }
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


    // kth smallest number
    public static int kSmallest(int[] arr, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i < arr.length; i++){
            q.offer(arr[i]);
            if(q.size()>k){
                q.poll();
            }
        }

        return q.poll();
    }

    public static int kLargest(int[] arr , int k){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            q.offer(arr[i]);
            if(q.size()> k){
                q.poll();
            }
        }

        return q.poll();
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 30, 70, 5, 7, 35};

        System.out.println("k smallest:: "+kSmallest(arr, 3));
        System.out.println("k largest:: "+kLargest(arr, 3));

        //createMaxHeap(arr);
//        for(int i = arr.length/2; i>0; i--){
//            arr = hipify(arr, i, arr.length);
//        }
//
//        arr = remove(arr, 2);
    }
}
