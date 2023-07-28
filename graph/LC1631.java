package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1631 {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int[] row: dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.absDiff));
        pq.add(new Cell(0, 0, 0));
        while(!pq.isEmpty()){

            Cell currCell = pq.poll();
            int currRow =  currCell.row;
            int currCol  = currCell.col;
            int currDiff = currCell.absDiff;
            if(currRow == n -1 && currCol == m -1 ) return currDiff;
            for(int i = 0; i < dir.length; i++){

                int nextRow = currRow + dir[i][0];
                int nextCol = currCol + dir[i][1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){

                    int absDiff = Math.abs(heights[currCell.row][currCell.col] - heights[nextRow][nextCol]);
                    int newEffort = Math.max(absDiff, currDiff);

                    if(newEffort <  dist[nextRow][nextCol] ){
                        dist[nextRow][nextCol] = newEffort;
                        pq.add(new Cell(nextRow, nextCol, newEffort));
                    }
                }
            }
        }

        return heights[n - 1][m -1];
    }

    class Cell{
        int row;
        int col;
        int absDiff;

        Cell(int row, int col, int absDiff){
            this.row = row;
            this.col = col;
            this.absDiff = absDiff;
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int ans = new LC1631().minimumEffortPath(heights);
        System.out.println(ans);
    }
}
