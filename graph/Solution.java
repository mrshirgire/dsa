package graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair_ {
    int row;
    int col;

    Pair_(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Solution
{
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
      
       int n = image.length;
       int m = image[0].length;
     
      int[][] vis = new int[n][m];
      int starPixel = image[sr][sc];
      
      Queue<Pair_> q = new LinkedList<>();
      q.add(new Pair_(sr, sc));
      vis[sr][sc] = 1;
      image[sr][sc] = newColor;
      
      int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      while(!q.isEmpty()){

          Pair_ currPair = q.poll();
          int currRow = currPair.row;
          int currCol = currPair.col;
          
           for(int i = 0; i < dir.length; i++){
              
                int nextRow = currRow + dir[i][0];
                int nextCol = currCol + dir[i][1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
                    
                    if(vis[nextRow][nextCol] == 0 && image[nextRow][nextCol] == starPixel ){
                        q.add(new Pair_(nextRow, nextCol));
                        image[nextRow][nextCol] = newColor;
                        vis[nextRow][nextCol] = 1;
                    }
                }
          }
      }
      
      return image;
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int[][] out = floodFill(image,1,1, 2);
        System.out.println(out);
    }
}