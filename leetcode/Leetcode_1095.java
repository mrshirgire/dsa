package leetcode;

public class Leetcode_1095 {

    public static void main(String[] args) {
        int[] array = {1,5,2};
        int target = 2;

        int ans = findInMountain(array, target);
        System.out.println(ans);
    }

    private static int findInMountain(int[] array, int target) {
        int ans = -1;
        int mountainIndex = findMountainIndex(array);
        if(mountainIndex!= -1){
            int start = 0;
            int end = mountainIndex;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(array[mid] == target){
                    ans = mid;
                    end = mid - 1;
                }else if(target > array[mid]){
                    start = mid + 1;
                }else if (target < array[mid]){
                    end = mid - 1;
                }
            }

            if(ans == -1){
                start = mountainIndex;
                end = array.length;

                while(start <= end){
                    int mid = start + (end - start)/2;
                    if(array[mid] == target){
                        ans = mid;
                        end = mid - 1;
                    }else if(target > array[mid]){
                        start = mid + 1;
                    }else if (target < array[mid]){
                        end = mid - 1;
                    }
                }
            }
        }

        return ans;
    }

    private static int findMountainIndex(int[] array) {

        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            if(start == end){
                return start;
            }

            int mid = start + (end - start)/2;
            if(array[mid] > array[mid + 1]){
                end = mid;
            }else if(array[mid + 1] > array[mid]) {
                start = mid + 1;
            }else{
                start = mid;
            }
        }

        return -1;
    }
}
