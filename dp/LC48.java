package dp;

public class LC48 {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for(int i = 0; i< matrix.length/2; i++){

            int start = i;
            int end =  n - 1 - i;
            int windowSize =  start == 0 ? end - start : end - start + 1;
            int[] leftMost = leftMost(matrix, start,  start,  end);
            int[] topMost = topMost(matrix,  start,  start,  end);
            int[] rightMost = rightMost(matrix,  end,  start,  end);
            int[] bottomMost = bottomMost(matrix,  end,  start,  end);

            // replace topmost row
            int index = 0;
            for(int col = start; col <= windowSize; col++){
                matrix[start][col] = leftMost[index];
                index++;
            }

            // replace rightmost col
            index = 0;
            for(int row = start; row <= windowSize; row++){
                matrix[row][end] = topMost[index];
                index++;
            }

            // replace bottom most row
            index = 0;
            for(int col1 = start; col1 <= windowSize; col1++){
                matrix[end][col1] = rightMost[index];
                index++;
            }

            // replace left most row
            index = 0;
            for(int row1 = start; row1 <= windowSize; row1++){
                matrix[row1][start] = bottomMost[index];
                index++;
            }
        }

        System.out.println(matrix);
    }

    int[] topMost(int[][] matrix, int row, int start, int end){

        int[] topMost = new int[end - start + 1];
        int index = 0;
        for(int i = start; i <= end; i++){
            topMost[index] = matrix[row][i];
            index++;
        }

        return topMost;
    }

    int[] rightMost(int[][] matrix, int col, int start, int end){

        int[] rightMost = new int[end - start + 1];
        int index = 0;
        for(int i = end; i >=start; i--){
            rightMost[index] = matrix[i][col];
            index++;
        }

        return rightMost;
    }

    int[] bottomMost(int[][] matrix, int row, int start, int end){

        int[] bottomMost = new int[end - start + 1];
        int index = 0;
        for(int i = start; i <= end; i++){
            bottomMost[index] = matrix[row][i];
            index++;
        }

        return bottomMost;
    }

    int[] leftMost(int[][] matrix,  int col, int start, int end){

        int[] leftMost = new int[end - start + 1];
        int index = 0;
        for(int i = end; i >= start; i--){
            leftMost[index] = matrix[i][col];
            index++;
        }

        return leftMost;
    }

    public static void main(String[] args) {
        //int[][]  matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][]  matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        LC48 lc48 = new LC48();
        lc48.rotate(matrix);
    }
}
