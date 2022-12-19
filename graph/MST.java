package graph;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;

public class MST {

    public static class Node{
        int val;
        int weight;

        Node(int val, int weight){
            this.val = val;
            this.weight = weight;
        }
    }

    public void primsAlgo(Node[][] adj){

        int n = adj.length;
        int[] dist = new int[n];
        boolean[] mst = new boolean[n];
        int[] parent = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);

        dist[0] = 0;
        for(int k=0; k <n;k++ ){

            int min =Integer.MAX_VALUE; int minIndex = 0;
            for(int i = 0; i < n; i++){
                if(mst[i] == false && dist[i] < min){
                    min = dist[i];
                    minIndex = i;
                }
            }

            mst[minIndex] = true;

            Node[] list = adj[minIndex];
            for(int i =0; i<list.length; i++){

                Node node = list[i];
                if(mst[node.val] == false && node.weight < dist[node.val]){
                    dist[node.val] = node.weight;
                    parent[node.val] = minIndex;
                }
            }
        }
    }




    public static void main(String[] args) {

    }
}
