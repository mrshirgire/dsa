package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC694 {

    int[][] vis;
    int[][] dir =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        vis = new int[n][m];
        Set<List<Integer>> set = new HashSet<>();
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(vis[row][col] == 0 && grid[row][col] == 1){
                    List<Integer> list = new ArrayList<>();
                    dfs(row, col ,row, col, grid, list);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    public void dfs(int row, int col, int br, int bc, int[][] grid, List<Integer> list){

        vis[row][col] = 1;
        list.add(br - row);
        list.add(bc - col);

        for(int i =0; i < dir.length; i++){
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];

            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length){
                if(grid[nextRow][nextCol] == 1 && vis[nextRow][nextCol] == 0){
                    dfs(nextRow, nextCol, br, bc, grid, list);
                }
            }
        }

    }
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        int ans  = new LC694().countDistinctIslands(grid);
        System.out.println(ans);
    }
}

class Pair1{
    int a;
    int b;
    Pair1(int a, int b){
        this.a =a;
        this.b = b;
    }


}
