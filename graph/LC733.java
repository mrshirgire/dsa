package graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC733 {
    int[][] dir =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

//        int n = image.length;
//        int m = image[0].length;
//        int initialColor = image[sr][sc];
//        Queue<Cell> q = new LinkedList<>();
//        q.add(new Cell(sr, sc));
//        image[sr][sc] = color;
//
//
//        while(!q.isEmpty()){
//            Cell cell = q.poll();
//            for(int i =0; i < dir.length; i++){
//                int nextRow = cell.row + dir[i][0];
//                int nextCol = cell.col + dir[i][1];
//
//                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
//                    if(image[nextRow][nextCol] == initialColor){
//                        image[nextRow][nextCol] = color;
//                        q.add(new Cell(nextRow, nextCol));
//                    }
//                }
//            }
//        }
        if(image[sr][sc]  == color) return image;
        dfs( sr,  sc,  image, image[sr][sc], color);
        return image;
    }

    public void dfs(int row, int col, int[][] image, int initialColor, int color){

        image[row][col] = color;
        for(int i =0; i < dir.length; i++){
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];

            if(nextRow >= 0 && nextRow < image.length && nextCol >= 0 && nextCol < image[0].length){
                if(image[nextRow][nextCol] == initialColor){
                    dfs(nextRow, nextCol, image, initialColor, color);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
//        int sr = 1;
//        int sc = 1;
//        int color = 2;

        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 0;
        int sc = 0;
        int color = 0;

        new LC733().floodFill(image, sr, sc,color);
        System.out.println();
    }
}

class Cell{
    int row;
    int col;
    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
