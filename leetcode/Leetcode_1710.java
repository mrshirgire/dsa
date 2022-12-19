package leetcode;

import java.util.Arrays;

public class Leetcode_1710 {

    public static void main(String[] args) {
        int[][] boxTypes = {
            //boxes, Units
                {5,10},
                {2,5},
                {4,7},
                {3,9}
        };

        int truckSize = 10; //  maximum number of boxes that can be put on the truck
        int[][] dp = new int[boxTypes.length + 1][truckSize +1];

        for(int i=0; i <= boxTypes.length; i++) {
            for(int j=0; j <= truckSize; j++){
                dp[i][j] = -1;
            }
        }
        /*int[][] dp = {
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
        };*/
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b)->b[1] - a[1]);
        int unitCount = 0;
        for(int[] boxType: boxTypes){
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount = unitCount + boxCount * boxType[1];

            truckSize = truckSize - boxCount;
            if (truckSize == 0)
                break;
        }

       return unitCount;
    }
}
