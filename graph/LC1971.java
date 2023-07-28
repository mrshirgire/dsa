package graph;

import java.util.ArrayList;
import java.util.List;

public class LC1971 {

    static int[] parent;
    static int[] size;
    static int[] rank;
    static int  findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }


    static void unionByRank(int node1, int node2){

        int node1Parent = findParent(node1);
        int node2Parent = findParent(node2);

        if(node1Parent == node2Parent) return;
        if(rank[node1Parent] == rank[node2Parent]){
            parent[node2Parent] = node1Parent;
            rank[node1Parent]++;
        }else if(rank[node1Parent] > rank[node2Parent]){
            parent[node2Parent] = node1Parent;
        }else {
            parent[node1Parent] = node2Parent;
        }
    }

    static void unionBySize(int node1, int node2, int[] parent, int[] size){

        int node1Parent = findParent(node1);
        int node2Parent = findParent(node2);

        if(node1Parent == node2Parent) return;
        if(size[node2Parent] > size[node1Parent]){
            parent[node1Parent] = node2Parent;
            size[node2Parent]+= size[node1Parent];
        }else{
            parent[node2Parent] = node1Parent;
            size[node1Parent]+=  size[node2Parent];
        }
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        parent = new int[n];
      //  size = new int[n];
        rank =  new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
          //  size[i] = 1;
        }


        for(int[] edge: edges){
           // unionBySize(edge[0], edge[1]);
            unionByRank(edge[0], edge[1]);
        }

        if(parent[source] == parent[destination])
            return true;
        else
            return false;

       /* List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        vis[source] = 1;
        return dfs(source, destination, adjList, vis);*/
    }

    static boolean dfs(int source, int destination, List<List<Integer>> adjList, int[] vis){

        if(source == destination) return true;

        for(int adjNode: adjList.get(source)){
            if(vis[adjNode] == 0){
                vis[adjNode] = 1;
                return dfs(adjNode, destination, adjList, vis);
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] edges =  {{2,6},{4,7},{1,2},{3,5},{7,9},{6,4},{9,8},{0,1},{3,0}};

        boolean validPath = validPath(10, edges, 3,5);
        System.out.println(validPath);
    }
}
