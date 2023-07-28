public class CyclicSort {


    int[] cyclicSort(int[] arr){

        for(int i = 0; i < arr.length; i++){

            // for 0-n unsorted array
            while(arr[i] != i){
                swap(i, arr[i], arr);
            }

            // for 1-n unsorted array
           /* while(arr[i] != i+1){
                swap(i, arr[i] - 1, arr);
            }*/
        }

        return arr;
    }

    void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        CyclicSort cyclicSort = new CyclicSort();
        int[] input = {0, 4, 2, 3, 1};
        int [] ans = cyclicSort.cyclicSort(input);
        for(int i = 0; i< input.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
