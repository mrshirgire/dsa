package leetcode;

import graph.LeetCode_797;

import java.util.*;

public class Leetcode_1976 {

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


        Map<Integer, List<Edge>> map = new HashMap<>();
        for(int[] road: roads){
            map.computeIfAbsent(road[0], f -> new ArrayList<>()).add(new Edge(road[1], road[2]));
            map.computeIfAbsent(road[1], f -> new ArrayList<>()).add(new Edge(road[0], road[2]));
        }

        List<DistNode> disNodeList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            disNodeList.add(new DistNode(Integer.MAX_VALUE, 0));
        }
        int mod = (int) (1e9 + 7);
        disNodeList.get(0).time = 0;
        disNodeList.get(0).noOfWays = 1;
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.time));
        q.add(new Edge(0, 0));
        while(!q.isEmpty()){

           // int qSize = q.size();
           // for(int i = 0; i < qSize; i++){

                Edge currEdge = q.poll();
                int currTime = disNodeList.get(currEdge.val).time;
                List<Edge> adjList1 = map.computeIfAbsent(currEdge.val, f -> new ArrayList<>());
                for(Edge adjEdge: adjList1){

                    int newTime = currTime + adjEdge.time;
                    if(newTime <  disNodeList.get(adjEdge.val).time){
                        disNodeList.get(adjEdge.val).time = newTime;
                        q.add(adjEdge);
                        disNodeList.get(adjEdge.val).noOfWays = disNodeList.get(currEdge.val).noOfWays;
                    }else if(newTime == disNodeList.get(adjEdge.val).time){
                        disNodeList.get(adjEdge.val).noOfWays = (disNodeList.get(adjEdge.val).noOfWays +
                                disNodeList.get(currEdge.val).noOfWays) % mod;
                    }
                }
           // }
        }

        return disNodeList.get(n-1).noOfWays % mod;
    }

    class Edge{
        int val;
        int time;
        Edge(int val, int time){
            this.val = val;
            this.time = time;
        }
    }

    class DistNode {
        int time;
        int noOfWays;
        DistNode(int time, int noOfWays){
            this.time = time;
            this.noOfWays = noOfWays;
        }
    }


    public static void main(String[] args) {

        int[][] graph = {{1,0,2348},{2,1,2852},{2,0,5200},{3,1,12480},{2,3,9628},{4,3,7367},{4,0,22195},
        {5,4,5668},{1,5,25515},{0,5,27863},{6,5,836},{6,0,28699},{2,6,23499},{6,3,13871},{1,6,26351},
        {5,7,6229},{2,7,28892},{1,7,31744},{3,7,19264},{6,7,5393},{2,8,31998},{8,7,3106},{3,8,22370},{8,4,15003},
        {8,6,8499},{8,5,9335},{8,9,5258},{9,2,37256},{3,9,27628},{7,9,8364},{1,9,40108},{9,5,14593},{2,10,45922},
        {5,10,23259},{9,10,8666},{10,0,51122},{10,3,36294},{10,4,28927},{11,4,25190},{11,9,4929},{11,8,10187},
        {11,6,18686},{2,11,42185},{11,3,32557},{1,11,45037}};
        //int[][] graph = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        new Leetcode_1976().countPaths(12, graph);
    }
}
