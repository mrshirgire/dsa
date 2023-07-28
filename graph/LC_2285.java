package graph;

import java.util.*;

public class LC_2285 {
    List<List<Integer>> adjList = new ArrayList<>();
    public long maximumImportance(int n, int[][] roads) {

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] road: roads){
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }

        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int adjNode: adjList.get(i)){
                inDegree[adjNode]++;
            }
        }
        List<InDegree> list = new ArrayList<>();
          for(int i = 0; i < n; i ++){
            list.add(new InDegree(i, inDegree[i]));
        }

        int[] importance = new int[n];
        Collections.sort(list,((o1, o2) -> o2.inDegreeVal - o1.inDegreeVal));
        int val = n;
        for(InDegree currInDegree: list){
            importance[currInDegree.v] = val;
            val--;
        }

        int ans = 0;
        for(int[] road: roads){
            ans+= importance[road[0]] + importance[road[1]];
        }

        return ans;

    }


    class InDegree {
        int v;
        int inDegreeVal;

        InDegree(int v, int inDegreeVal){
            this.v = v;
            this.inDegreeVal = inDegreeVal;
        }
    }

    public static void main(String[] args) {
        int n = 2;
       // int[][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int[][] roads = {{0,1}};
        System.out.println(new LC_2285().maximumImportance(n, roads));
    }
}
