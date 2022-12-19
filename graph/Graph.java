package graph;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    static List<Integer>[] adj;
    List<Integer> bfs = new ArrayList<>();

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);
//
//        System.out.println(graph.BFS(0, 3));
//        boolean isVisited[] = new boolean[ adj.length];
//        isVisited[0] = true;
//        System.out.println(graph.DFS(0, 3, isVisited));

        boolean bipartite = graph.bipartite();
        System.out.println(bipartite);


    }

    Graph(int noOfVertices){
        adj = new LinkedList[noOfVertices];
        for(int i = 0; i<noOfVertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }




    public void bfs(LinkedList<Integer>[] adj, boolean[] isVisited, int source){

        Queue<Integer> q = new LinkedList<>();
        if(!isVisited[source]){
            q.offer(source);
            isVisited[source] = true;
        }

        while(!q.isEmpty()){

            Integer source1 =  q.poll();
            bfs.add(source1);
            List<Integer> destList = adj[source];
            for(int i = 0; i < destList.size(); i++){

                int dest = destList.get(i);
                if(!isVisited[dest]){
                    q.offer(dest);
                    isVisited[dest] = true;
                }
            }
        }
    }

    public int BFS(int source, int destination){
        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[ adj.length];
        int[] origin = new int[adj.length];

        origin[source] = -1;
        isVisited[source] = true;
        q.add(source);

        while(!q.isEmpty()){

            int vertex = q.poll();

            for(int neighbor:  adj[vertex]){
                if(!isVisited[neighbor]){
                    isVisited[neighbor] = true;
                    origin[neighbor] = vertex;
                    q.add(neighbor);
                }
            }
        }

        int currVertex = destination;
        int distance = 0;
        while(origin[currVertex] != -1){
            currVertex = origin[currVertex];
            distance++;
        }

        return distance;
    }

//    dfs(ListList<Integer>[] adj, boolean[] isVisited, int source){
//
//        if(isVisited[source]){
//            return
//        }
//
//        dfs.add(source);
//        isVisited[source] = true;
//
//        List<Integer> list =  adj[source];
//        for(int i = 0; i < list.length; i++){
//            int newSOurce = list.get(i);
//            dfs(adj, isVisited. newSource);
//        }
//    }


    public boolean DFS(int source, int destination, boolean[] visited){

        if(source == destination) return true;

        for(int neighbor: adj[source]){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                boolean isConnected = DFS(neighbor, destination, visited);

                if(isConnected) return true;
            }
        }

        return false;
    }


    static class Node_{
        int val;
        int parent;

        Node_(int val, int parent){
            this.val = val;
            this.parent = parent;
        }
    }

    boolean isCycle(LinkedList<Integer>[] adj, boolean[] isVisited, int source){

        if(isVisited[source]){
            return true;
        }

        Queue<Node_> q = new LinkedList<>();
        q.offer(new Node_(0, -1));

        while(!q.isEmpty()){

            Node_ node = q.poll();
            int source1 = node.val;
            List<Integer> destList = adj[source];

            for(int i = 0; i < destList.size(); i++){
                int dest = destList.get(i);
                if(isVisited[dest] && dest != node.parent){
                    return true;
                }else{
                    isVisited[dest] = true;
                    q.offer(new Node_( dest, source1));
                }
            }
        }

        return false;
    }

    public static boolean bipartite(){

        int n = adj.length;
        int[] colorArr = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        colorArr[0] = 1;

        while(!q.isEmpty()){
            int nodeVal = q.poll();
            List<Integer> list = adj[nodeVal];

            for(int i = 0; i < list.size(); i++){
                int adjEl = list.get(i);
                if(colorArr[adjEl] == 0){
                    int color = colorArr[nodeVal] == 1? 2: 1;
                    colorArr[adjEl] = color;
                    q.offer(adjEl);
                }else if(colorArr[adjEl] == colorArr[nodeVal]){
                    return false;
                }
            }
        }

        return true;
    }

}
