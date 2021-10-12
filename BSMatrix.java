import java.util.Arrays;

public class BSMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {11, 21, 31, 41},
                {12, 22, 32, 42},
                {13, 23, 33, 43},
        };

        int lowerBond = 0;
        int upperBond = matrix[0].length-1;

        //int ans[] = binarySearch(matrix, 40, lowerBond, upperBond);
        int ans[] = binarySearch(matrix, 31);
        System.out.println(Arrays.toString(ans));
    }


    private static int[] binarySearch(int[][] matrix, int target){

        int row = 0;
        int column = matrix.length - 1;
        while (row < matrix.length && column >=0) {
            if(target == matrix[row][column])
                return new int[]{row, column};

            if(target < matrix[row][column]){
                column--;
            }else if(target > matrix[row][column]){
                row++;
            }
        }

        return new int[]{-1, -1};
    }

    //recuresive method
    private static int[] binarySearch(int[][] matrix, int target, int lowerBond, int upperBond ) {

        if(lowerBond>matrix[0].length-1 || upperBond < 0)
            return new int[]{-1, -1};

        if(target == matrix[lowerBond][upperBond]){
            return new int[]{lowerBond, upperBond };
        }

        if(target < matrix[lowerBond][upperBond]){
            upperBond--;
        }else if(target > matrix[lowerBond][upperBond]){
            lowerBond++;
        }

        return binarySearch(matrix, target, lowerBond, upperBond );

        //return new int[]{-1, -1};
    }


}
