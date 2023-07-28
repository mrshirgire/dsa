package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_797 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if(graph.length == 0 || graph[0].length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph,res,list, 0);
        return res;
    }

    public void dfs(int[][] graph,List<List<Integer>> res,List<Integer> list,int pos){

        if(pos == graph.length - 1){
            res.add(new ArrayList<>(list));
        }else{
            for(int d:graph[pos]){
                list.add(d);
                dfs(graph,res,list,d);
                list.remove(list.size()-1);
            }
        }

//        int[] adjNodes = graph[source];
//        if(adjNodes.length == 0){
//            ans.add(new ArrayList<>(path));
//            return;
//        }
//
//        for(int adjNode: adjNodes){
//            path.add(adjNode);
//            dfs(adjNode, ans, graph, path);
//            path.remove(path.size()-1);
//        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4}, {}, {4},{}};
        new LeetCode_797().allPathsSourceTarget(graph);
        List<List<Integer>> edges = new ArrayList<>();
        edges.stream().filter(list1->list1.get(0) == 0)
                .collect(Collectors.toList());
    }
}
