package graph;

import java.util.ArrayList;
import java.util.List;

public class LC2685 {

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int [n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                boolean bool = dfs(i, -1, vis, adjList);
                if(bool) count++;
            }
        }

        return count;

    }

    boolean dfs(int node, int parent, int[] vis,  List<List<Integer>> adjList ){

        vis[node] = 1;

        if(parent == -1 && adjList.get(node).size() == 0) return true;

        for(int adjNode: adjList.get(node)){
            if(vis[adjNode] == 1 && adjNode != parent){
                return true;
            }else if(vis[adjNode] == 0){
                return dfs(adjNode, node, vis, adjList);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC2685 lc2685 = new LC2685();
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        int count  = lc2685.countCompleteComponents( n, edges);
        System.out.println(count);
    }
}
