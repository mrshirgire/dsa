package ola;

import java.util.Arrays;

public class ProductOfAray {

    //bruteforce sol
    public static int[] getProduct(int[] arr){

        int[] output = new int[arr.length];
        for(int i = 0; i<arr.length; i++){

            int ans = 1;
            for(int j = 0; j< arr.length; j++){
                if(j != i)
                    ans = ans * arr[j];
            }

            output[i] = ans;
        }

        return output;
    }

    public static int[] geProduct_(int[] arr){

        int[] out = new int[arr.length];
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for(int i = 0, j = arr.length -1; i<arr.length; i++, j--){
            if(i == 0){
                left[i] = arr[i];
            }else{
                left[i] = left[i - 1] * arr[i];
            }

            if(j == arr.length -1){
                right[j] = arr[j];
            }else{
                right[j] = right[j + 1] * arr[j];
            }
        }

        for(int i= 0; i< arr.length; i++){
            if(i == 0)
                out[i] = right[i + 1];
            else if( i == arr.length - 1)
                out[i] = left[i - 1];
            else{

                out[i] = left[i - 1] * right[i + 1];
            }
        }

        return out;

    }

    public  static int[] optimize(int[] arr){

        int[] output = new int[arr.length];

        for(int i = 0; i< arr.length; i++){

            if(i == 0){
                output[i] = arr[i];
            }else{
                output[i] = output[i - 1] * arr[i];
            }
        }
        int product = 1;
        for(int i = arr.length - 1; i>=0; i--){

            if(i == arr.length - 1){
                output[i] = output[i -1];
                product = product * arr[i];
            }else if(i == 0){
                output[i] = product;

            }else{
                output[i] = output[i - 1] * product;
                product = product * arr[i];
            }
        }

        return  output;
    }
    public static void main(String[] args) {
        int[] arr  = {1, 2, 3, 4};
        System.out.println(Arrays.toString(optimize(arr)));
    }




}
