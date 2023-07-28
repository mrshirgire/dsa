package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC1976 {

    public int countPaths(int n, int[][] roads) {

        List<List<Edge>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        int m = roads.length;
        for(int i = 0; i < m; i++){
            int[] edge = roads[i];
            adjList.get(edge[0]).add(new Edge(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        int[] dist = new int[n];
        int[] ways = new int[n];

        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.time));
        q.add(new Edge(0, 0));
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int) (1e9 + 7);
        while(!q.isEmpty()){
            Edge currEdge = q.poll();
            int currTime = currEdge.time;
            for(Edge adjEdge: adjList.get(currEdge.val)){
                int newTime = currTime + adjEdge.time;
                if(newTime <= dist[adjEdge.val]){
                    dist[adjEdge.val] = newTime;
                    q.add(new Edge(adjEdge.val, newTime));
                    ways[adjEdge.val] = ways[currEdge.val] +  ways[adjEdge.val];
                }
            }
        }

        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int ans = new LC1976().countPaths(n, roads);
        System.out.println(ans);

    }


    class Edge{
        int val;
        int time;
        Edge(int val, int time){
            this.val = val;
            this.time = time;
        }
    }
}
