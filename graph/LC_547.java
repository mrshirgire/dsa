package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_547 {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int m = isConnected[0].length;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(row == col) continue;
                if(isConnected[row][col] == 1){
                    adjList.get(row).add(col);
                }
            }
        }

        int[] isVisited = new int[n];
        int count  = 0;
        for(int i = 0; i < n; i++){
            if(isVisited[i] == 0){
                bfs(i, adjList, isVisited);
                count++;
            }

        }

        return count;
    }

    public void bfs(int node, List<List<Integer>> adjList, int[] isVisited){

        isVisited[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int adjNode: adjList.get(currNode)){
                if(isVisited[adjNode] == 0){
                    q.add(adjNode);
                    isVisited[adjNode] = 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph= {{1,1,0},{1,1,0},{0,0,1}};
        new LC_547().findCircleNum(graph);
    }
}
