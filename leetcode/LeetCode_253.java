package leetcode;


import java.util.Arrays;

// 253. Meeting Rooms II
public class LeetCode_253 {

    public static int minMeetingRooms(int[][] intervals) {

        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for(int i = 0; i<intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);

        for(int i = endTime.length/2; i>0; i--){
            endTime = hipify(endTime, i, endTime.length);
        }

        int roomCnt = 0;
        int len = endTime.length;
        for(int idx = 0; idx<startTime.length;idx++){
            if(idx == 0)
                roomCnt++;
            else{
                if (startTime[idx] < endTime[0]){
                    roomCnt++;
                }else{
                    endTime = remove(endTime, 1, len);
                    len--;
                }
            }
        }

        return roomCnt;
    }

    public static int[] hipify(int[] arr, int currIndex, int length){

        int minIndex = currIndex;
        int leftIndex = 2 * currIndex;
        int rightIndex = 2 * currIndex + 1;

        if(leftIndex <= length && arr[leftIndex-1] < arr[minIndex-1]){
            minIndex = leftIndex;
        }

        if(rightIndex<=length && arr[rightIndex-1] < arr[minIndex-1]){
            minIndex = rightIndex;
        }

        if(minIndex != currIndex){
            arr = swap(arr, minIndex-1, currIndex-1);
            return hipify(arr, minIndex, length);
        }

        return arr;
    }

    private static int[] remove(int[] heap, int noOfElementsToRemove, int len){

        for(int i = 0; i < noOfElementsToRemove; i++){

            len--;
            heap = swap(heap, 0, len);

            for(int j = len/2; j>0; j--){
                heap = hipify(heap, j, len);
            }
        }

        return heap;
    }

    public static int[] swap(int[] maxHeap, int parentIndex, int j) {

        int temp = maxHeap[parentIndex];
        maxHeap[parentIndex] = maxHeap[j];
        maxHeap[j] = temp;

        return maxHeap;
    }

    public static void main(String[] args) {
        int[][] intervals =  {{9,14},{5,6},{3,5},{12,19}};

        System.out.println(minMeetingRooms(intervals));
    }


}
