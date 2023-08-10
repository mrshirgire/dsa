package bitmanuplition;

public class OnceOccursInteger {

    static int getOnceOccursInteger(int[] arr){

        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 3, 1, 7, 8,5, 8};
        System.out.println(getOnceOccursInteger(arr));
    }
}
