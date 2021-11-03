public class RainWaterTrapping {

    public static void main(String[] args) {

        int[] arr = {3, 0, 0, 2, 0, 4};

        int[] maxl = new int[arr.length];
        int[] maxr = new int[arr.length];

        maxl[0] = arr[0];
        for(int i = 1; i< arr.length; i++){
            maxl[i] = maxl[i-1] > arr[i] ? maxl[i-1] : arr[i];
        }

        maxr[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i>=0; i--){
            maxr[i] = maxr[i+1] > arr[i] ? maxr[i+1] : arr[i];
        }
        int rainTrappingArea = 0;
        for(int i = 0; i < arr.length; i++){
            rainTrappingArea += Math.min(maxl[i], maxr[i]) - arr[i];
        }

        System.out.println(rainTrappingArea);
    }


}
