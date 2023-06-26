package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    public boolean isBipartite(int[][] adj) {

        if(adj.length == 0) return true;

        int n = adj.length;
        int[] colorArr = new int[n];

        for(int i = 0; i< adj.length; i++){
            if(colorArr[i] == 0 ){
                boolean isBipartite = bfs(i, adj, colorArr);
                if(!isBipartite) return false;
            }
        }

        return true;

    }

    public boolean bfs(int node, int[][] adj, int[] colorArr){

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        colorArr[node] = 1;

        while(!q.isEmpty()){
            int nodeVal = q.poll();
            int[] list = adj[nodeVal];

            for(int i = 0; i < list.length; i++){
                int adjEl = list[i];
                if(colorArr[adjEl] == 0){
                    colorArr[adjEl] = colorArr[nodeVal] == 1? 2: 1;;
                    q.offer(adjEl);
                }else if(colorArr[adjEl] == colorArr[nodeVal]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
