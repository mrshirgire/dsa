package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1293 {
    static class Node{
        int row;
        int col;
        int power;

        Node(int row, int col,int power){
            this.row = row;
            this.col = col;
            this.power =power;
        }
    }

    public static int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        if(m == 1 && n == 1) return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] power = new int[grid.length][grid[0].length];
        for (int[] row: power){
            Arrays.fill(row, -1);
        }

        int level = 0;

        int[][] dir = {
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0}
        };

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, k));
        visited[0][0] = 1;
        while(!q.isEmpty()){

            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                Node currentNode = q.poll();
                int currentRow = currentNode.row;
                int currentCol = currentNode.col;

                if(currentRow == n - 1 && currentCol == m -1 ) return level;
                for(int j = 0; j< dir.length;j++){

                    int newRow = currentRow + dir[j][0];
                    int newCol = currentCol + dir[j][1];
                    if(newRow >= 0 && newRow < n && newCol>=0 && newCol<m){

                        if(visited[newRow][newCol] == 0 && grid[newRow][newCol] != 1){
                            q.offer(new Node(newRow, newCol,  currentNode.power));
                            visited[newRow][newCol] = 1;
                            power[newRow][newCol] = currentNode.power;
                        }else if(grid[newRow][newCol] == 1 && currentNode.power - 1 > power[newRow][newCol]){
                            q.offer(new Node(newRow, newCol,  currentNode.power - 1));
                            power[newRow][newCol] =  currentNode.power - 1;
                            visited[newRow][newCol] = 1;
                        }else if(visited[newRow][newCol] == 1 && currentNode.power > power[newRow][newCol]) {
                            q.offer(new Node(newRow, newCol,  currentNode.power));
                            power[newRow][newCol] = currentNode.power;
                        }
                    }

                }
            }
            level++;


        }

        return -1;

    }


    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}};
        int k = 1;
        System.out.println(shortestPath(grid, k));

    }
}
