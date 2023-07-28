package google;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5};
        int k=2;
        System.out.println(arrLen(arr,k));
    }

    static int arrLen(int[] arr,int k){

        int[] newArr = arr;
        for(int i = 0; i<k; i++){
            int num  = newArr[newArr.length-1];
            do{
                newArr =  Arrays.copyOfRange(newArr, 0, newArr.length-1);

            }while(newArr[newArr.length-1] == num);
        }

        return newArr.length;
    }
}
