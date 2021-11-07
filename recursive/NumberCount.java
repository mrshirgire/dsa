package recursive;

import java.util.ArrayList;
import java.util.List;

public class NumberCount {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 4, 9, 4};
        int target = 4;
//        List<Integer> list =getCount(arr, target, 0);
//        System.out.println(list);

        printPattern(4, 0, 4);
    }

    public static List<Integer> getCount(int[] arr, int target, int index){

        List<Integer> list = new ArrayList<>();

        if(arr[index] == target)
            list.add(index);

        if(index == arr.length - 1){
            return list;
        }

        list.addAll(getCount(arr, target, index+1));

        return list;
    }

    public static void printPattern(int r, int c, int n){

        if(r == 0 ) return;

        if(c < r){
            System.out.print(" *");
            printPattern(r, c + 1, n);
        }else{
            System.out.println();
            printPattern(r - 1 ,  0, n);
        }
     }

}
