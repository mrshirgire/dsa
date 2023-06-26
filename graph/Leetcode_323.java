package graph;

import java.util.*;

public class Leetcode_323 {

    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{1,0}};
        System.out.println(new Leetcode_323().countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
        }

        int[] inDegrees = new int[n];
        for(int[] edge: edges){
            inDegrees[edge[1]]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.inDegree));
        for(int i = 0; i < n; i++){
            pq.add(new Pair(i,inDegrees[i]));
        }

        int[] visited = new int[n];
        int count = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.val;
            if(visited[node] == 0){
                bfs(node, visited, adjList);
                count++;
            }
        }

        return count;
    }


    public void bfs(int node, int[] visited, List<List<Integer>> adjList){

        visited[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){

            int currNode = q.poll();
            for(int adjNode: adjList.get(currNode)){
                if(visited[adjNode] == 0){
                    q.add(adjNode);
                    visited[adjNode] = 1;
                }
            }
        }
    }
}

class Pair {
    int val;
    int inDegree;

    public Pair(int val, int inDegree){
        this.val = val;
        this.inDegree = inDegree;
    }

}
