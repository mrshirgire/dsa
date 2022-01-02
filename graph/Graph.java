package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    static LinkedList<Integer>[] adj;

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println(graph.BFS(0, 3));
        boolean isVisited[] = new boolean[ adj.length];
        isVisited[0] = true;
        System.out.println(graph.DFS(0, 3, isVisited));


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

    public int BFS(int source, int destination){
        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[ adj.length];
        int[] origin = new int[adj.length];

        origin[source] = -1;
        isVisited[source] =true;
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
}
