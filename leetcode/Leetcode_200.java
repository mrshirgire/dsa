package leetcode;

import java.util.List;
import java.util.Stack;

public class Leetcode_200 {

    public static class Island{
        int i;
        int j;

        public Island(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                    {'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));


    }

    public static int numIslands(char[][] grid) {

        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++){
            for(int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++){
                isVisited[rowIndex][colIndex] = false;
            }
        }

        int count = 0;
        Stack<Island> stack = new Stack<>();
            for(int i = 0; i<grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){

                    if(grid[i][j] == '1' && !isVisited[i][j]){
                        //isVisited[i][j] = true;
                        count++;
                        stack.push(new Island(i,j));
                        stack = travelTillLand(grid, stack, isVisited);

                        /*isVisited = travelHorizontally(grid, i, j + 1, isVisited);
                        isVisited = travelVertically(grid, i + 1, j, isVisited);*/
                    }
                }
            }
        return count;
    }

    private static Stack<Island> travelTillLand(char[][] grid, Stack<Island> stack, boolean[][] isVisited) {

        if(stack.isEmpty()){
            return stack;
        }

        Island island = stack.pop();
        int i = island.getI();
        int j = island.getJ();
        //if(i - 1 < 0 || i + 1 > grid.length - 1 || j - 1 < 0 || j > grid[0].length - 1 || stack.isEmpty() )


        /* Move in below direction*/
        if(i <= grid.length - 2 && grid[i][j] == '1' && isVisited[i][j] == false){
            isVisited[i][j] = true;
            stack.push(new Island(i + 1, j));
            return travelTillLand(grid, stack, isVisited);
        }

        /* Move in above direction*/
        if(i >=1 && grid[i][j] == '1' && isVisited[i][j] == false){
            isVisited[i][j] = true;
            stack.push(new Island(i - 1, j));
            return travelTillLand(grid, stack, isVisited);
        }

        /* Move in right derection */
        if(j <= grid.length -2  && grid[i][j] == '1' && isVisited[i][j] == false){
            isVisited[i][j] = true;
            stack.push(new Island(i, j + 1));
            return travelTillLand(grid, stack, isVisited);
        }

        /* Move in left direction */
        if(j >=1  && grid[i][j] == '1' && isVisited[i][j] == false){
            isVisited[i][j] = true;
            stack.push(new Island(i, j - 1));
            return travelTillLand(grid, stack, isVisited);
        }



        return stack;
    }


    public static boolean[][] travelHorizontally(char[][] grid, int i, int j, boolean[][] isVisited) {

        if(j >= grid[i].length - 1 || grid[i][j] == '0' || isVisited[i][j])
            return isVisited;

        isVisited[i][j] = true;
        travelHorizontally(grid, i, j  + 1,  isVisited);
        travelVertically(grid, i + 1, j,  isVisited);
        return isVisited;
    }

    public static boolean[][] travelVertically(char[][] grid, int i, int j, boolean[][] isVisited) {

        if(i >= grid.length - 1 || grid[i][j] == '0' || isVisited[i][j])
            return isVisited;

        isVisited[i][j] = true;
        travelVertically(grid, i + 1, j,  isVisited);
        travelHorizontally(grid, i, j + 1,  isVisited);
        return isVisited;
    }


}
