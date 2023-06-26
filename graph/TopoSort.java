package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort {

    public static void main(String[] args) {

        //int[][] graph = {{1,0}};
        int[][] graph = {{1,0},{0,1}};
        //int[][] graph = {{1,4},{2,4},{3,1},{3,2}};
       // List<Integer> ans = topoSortUsingBFS(5, graph);
        List<Integer> ans = topoSortUsingDFS(2, graph);
        System.out.println(ans);

    }

    static List<Integer> topoSortUsingBFS(int n, int[][] graph){

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add( new ArrayList());
        }

        for(int[] edge: graph){
            int src = edge[1];
            int dest = edge[0];
            adjList.get(src).add(dest);
        }

        int[] inDegree = new int[n];
        for(int[] edge: graph){
            inDegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.add(i);
                topoSort.add(i);
            }
        }

        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int adjNode: adjList.get(currNode)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    q.add(adjNode);
                    topoSort.add(adjNode);
                }
            }
        }

        return topoSort;
    }
    static List<Integer> topoSortUsingDFS(int n, int[][] graph){

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add( new ArrayList());
        }

        for(int[] edge: graph){
            int src = edge[1];
            int dest = edge[0];
            adjList.get(src).add(dest);
        }

        int[] vis = new int[n];
        List<Integer> topoSort = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, topoSort,  adjList);
            }
        }

        return topoSort;
    }
    static public void dfs(int node, int[] vis, List<Integer> topoSort, List<List<Integer>> adjList){

        vis[node] = 1;
        for(int adjNode: adjList.get(node)){
            if(vis[adjNode] == 0){
                dfs(adjNode, vis, topoSort, adjList);
            }
        }
        topoSort.add(node);
    }
}
