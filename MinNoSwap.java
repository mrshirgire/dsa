import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinNoSwap {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2};
        System.out.println(getMinCount(arr));
    }

    public static int getMinCount(int[] arr){
        int ans = 0;

        // put indices in map
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            indexMap.put(arr[i], i );
        }

        //sort array
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        for(int i = 0; i<arr.length; i++){
            if(sortedArr[i] != arr[i]){
                //swap
                swap(arr, i, indexMap.get(sortedArr[i]));
                ans++;
            }
        }

        return ans;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
