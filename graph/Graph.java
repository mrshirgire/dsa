package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    LinkedList<Integer>[] adj;

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println(graph.BFS(0, 3));


    }

    Graph(int noOfVertices){
        adj = new LinkedList[noOfVertices];
        for(int i = 0; i<noOfVertices; i++){
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        this.adj[source].add(destination);
        this.adj[destination].add(source);
    }

    public int BFS(int source, int destination){
        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[ this.adj.length];
        int[] origin = new int[this.adj.length];

        origin[source] = -1;
        isVisited[source] =true;
        q.add(source);

        while(!q.isEmpty()){

            int vertex = q.poll();

            for(int neighbor:  this.adj[vertex]){
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
}
