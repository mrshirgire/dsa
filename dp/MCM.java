package dp;

public class MCM {


    static int min  = Integer.MAX_VALUE;
    public static int[][] dp = new int[6][6];
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};

        minCost(arr);
        System.out.println(min);
    }

    public static int minCost(int[] arr){

        //return mcmRecursive(arr, 1, arr.length-1);
        for(int i = 0; i< dp.length;i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return mcmMemorization(arr, 1, arr.length-1);
    }

    public static int mcmRecursive(int[] arr, int left, int right){

        if(left>=right){
            return 0;
        }

        for(int k = left; k<right; k++){
            int leftCost = mcmRecursive(arr,left,k);
            int rightCost = mcmRecursive(arr, k+1, right);
            int currentCost = arr[left -1] * arr[k] * arr[right];

            int totalCost = currentCost + leftCost + rightCost;
            min = Math.min(min,totalCost );
        }

        return min;
    }

    public static int mcmMemorization(int[] arr, int left, int right){

        if(left>=right){
            return 0;
        }

        if( dp[left][right] != -1){
            return dp[left][right];
        }

        for(int k = left; k<right; k++){
            int leftCost = mcmRecursive(arr,left,k);
            int rightCost = mcmRecursive(arr, k+1, right);
            int currentCost = arr[left -1] * arr[k] * arr[right];

            int totalCost = currentCost + leftCost + rightCost;
            min = Math.min(min,totalCost );
        }

        return dp[left][right] = min;
    }

}
