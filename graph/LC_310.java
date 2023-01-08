package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_310 {

    static int[] vis;
    static List<List<Integer>> adjList;
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] height = new int[n];

        int minHeight = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            vis = new int[n];
            int height_ = bfs(i);
            height[i] = height_;
            minHeight = Math.min(minHeight, height_);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(height[i] == minHeight){
                ans.add(i);
            }
        }

        return ans;

    }

    public static int bfs(int node){

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int currNode = q.poll();
                for(int adjNode: adjList.get(currNode)){
                    if(vis[adjNode] == 0){
                        q.add(adjNode);
                        vis[adjNode] = 1;
                    }
                }
            }
        }

        return level - 1;
    }

    public static void main(String[] args) {
        int n = 6;
        //int[][] edges = {{1,0},{1,2},{1,3}};
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> ans = findMinHeightTrees( n,  edges);
        System.out.println("ans:: "+ans);
    }
}
