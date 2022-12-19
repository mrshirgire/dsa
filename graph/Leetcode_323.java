package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_323 {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {

        int[] visited = new int[n];
        int count = 0;
        for(int i = 0; i<n;i++){
            if(visited[i] == 1) continue;
            dfs(i, visited, edges);
            count++;
        }
        return count;
    }


    public static void dfs(int i, int[] visited, int[][] edges){

        Stack<Integer> st = new Stack<>();
        st.push(i);
        visited[i] = 1;
        while(!st.isEmpty()){
            int num = st.pop();
            List<int[]> arr = new ArrayList<>();
            for(int k = 0; k<edges.length;k++){
                if(edges[k][0] == num){
                    arr.add(edges[k]);
                }
            }

            arr.forEach(elArr->{
                for(int j = 0; j<elArr.length;j++){
                    if(visited[elArr[j]] == 0){
                        st.push(elArr[j]);
                        visited[elArr[j]] = 1;
                    }
                }
            });
        }
    }
}
