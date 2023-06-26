package graph;

import java.util.ArrayList;
import java.util.List;

public class LC802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathVis, graph, check);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1) ans.add(i);
        }

        return  ans;
    }


    public boolean dfs(int node, int[] vis, int[] pathVis, int[][] graph, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        // = graph[node];
        for(int adjNode: graph[node]){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, vis, pathVis, graph, check)){
                    return true;
                }
            }else if(pathVis[adjNode] == 1)
                return true;
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> ans = new LC802().eventualSafeNodes(graph);
        System.out.println(ans);
    }
}
