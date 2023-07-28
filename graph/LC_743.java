package graph;

import java.util.*;

public class LC_743 {
    public static int networkDelayTime(int[][] times, int n, int k) {

        List<Edge>[] adjList = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adjList[i] = new LinkedList<>();
        }
        for(int[] time: times){
            adjList[time[0]].add(new Edge(time[0], time[1], time[2]));
        }

        int[] timeArr = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            timeArr[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {k, 0});
        timeArr[k] = 0;

        while(!q.isEmpty()){
            int[] pair = q.poll();
            for(Edge edge: adjList[pair[0]]){
                int newTime = pair[1] + edge.time;
                if(newTime < timeArr[edge.dest]){
                    timeArr[edge.dest] = newTime;
                    q.add(new int[] {edge.dest, newTime});
                }
            }
        }


        for(int i = 1; i < n + 1; i++){
            if(timeArr[i] == Integer.MAX_VALUE){
                return -1;
            }
        }
        int ans  = 0;
        for(int i = 1; i < n+1; i++){
            if(timeArr[i] > ans){
                ans = timeArr[i];
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}



class Edge{

    int src;
    int dest;
    int time;

    Edge(int src, int dest, int time){
        this.src = src;
        this.dest = dest;
        this.time = time;
    }
}
