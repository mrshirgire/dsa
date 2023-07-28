package leetcode;

import java.util.*;

public class Leetcode_787 {

    public static void main(String[] args) {
        int n = 2;
        int[][] flights = {{0,1,2}};
        int src = 1;
        int dst = 0;
        int k = 0;

        int res = new Leetcode_787().findCheapestPrice( n,  flights,  src,  dst,  k);
        System.out.println(res);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cost = new int[n];
        for(int i = 0; i < n; i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[src] = 0;
        Queue<Integer> q =  new LinkedList<>();
        q.add(src);
        int level = 0;
        while(!q.isEmpty() && level <= k){
            int qSize = q.size();
            for(int i = 0; i < qSize; i ++){
                int currNode = q.poll();
                for(int[] flight: flights){
                    if(flight[0] == currNode){
                        int newCost = cost[currNode] + flight[2];
                        if(newCost < cost[flight[1]]){
                            cost[flight[1]] = newCost;
                            q.add(flight[1]);
                        }
                    }
                }
            }
            level++;
        }

        return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];
       /* Map<Integer, List<Edge>> map = new HashMap<>();
        for(int[] flight: flights){
            if(map.containsKey(flight[0])){
                map.get(flight[0]).add(new Edge(flight[1], flight[2]));
            }else{
                List<Edge> edges = new ArrayList<>();
                edges.add(new Edge(flight[1], flight[2]));
                map.put(flight[0], edges);
            }

        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[src] = 0;
        Queue<Edge> q =  new LinkedList<>();
        q.add(new Edge(src, 0));
        int level = 0;
        while(!q.isEmpty() && level <= k){

            int qSize = q.size();
            for(int i = 0; i < qSize; i ++){
                Edge currEdge = q.poll();
                int currNode = currEdge.dest;
                int currCost = currEdge.cost;

                List<Edge> edges = map.get(currEdge.dest);
                if(edges == null){
                    edges = new ArrayList<>();
                }
                for(Edge edge: edges){

                    int newCost = currCost + edge.cost;
                    if(newCost < cost[edge.dest]){
                        cost[edge.dest] = newCost;
                        q.add(new Edge(edge.dest, newCost));
                    }
                }
            }

            level++;
        }


        return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];*/

    }

}

class Edge{

    int dest;
    int cost;
    Edge( int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}
