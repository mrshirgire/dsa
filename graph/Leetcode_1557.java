//package graph;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Leetcode_1557 {
//
//    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//
//        int[] inDegrees = new int[n];
//
//        for(List<Integer> edge: edges){
//            inDegrees[edge.get(1)]++;
//        }
//
//        List<Integer> list = new LinkedList<>();
//        int[] visited = new int[n];
//        int visitedCnt = 0;
//        for(int i = 0; i < n; i++){
//            if(inDegrees[i] == 0){
//                list.add(i);
//                visited[i] =1;
//                visitedCnt++;
//            }
//        }
//
//        Stack<Integer> st = new Stack<>();
//        Set<Integer> res = new ArrayList<>();
//        for(int node1: list){
//            st.add(node1);
//
//            while(!st.isEmpty()){
//                int node = st.pop();
//                List<List<Integer>> adjList = edges.stream()
//                        .filter(list1->list1.get(0) == node)
//                        .collect(Collectors.toList());
//
//                for(List<Integer> adjNode: adjList){
//                    if(visited[adjNode.get(1)] == 0){
//                        st.add(adjNode.get(1));
//                        visited[adjNode.get(1)]=1;
//                        visitedCnt++;
//                    }
//                }
//            }
//
//            res.add(node1);
//            if(visitedCnt == n) return res;
//        }
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//
//
//        List<List<Integer>> edges = new ArrayList<>();
//        List<Integer> edge1 = new ArrayList<>();
//        edge1.add(0);
//        edge1.add(1);
//
//        List<Integer> edge2 = new ArrayList<>();
//        edge2.add(2);
//        edge2.add(1);
//
//        List<Integer> edge3 = new ArrayList<>();
//        edge3.add(3);
//        edge3.add(1);
//
//        List<Integer> edge4 = new ArrayList<>();
//        edge4.add(1);
//        edge4.add(4);
//
//        List<Integer> edge5 = new ArrayList<>();
//        edge5.add(2);
//        edge5.add(4);
//
//        edges.add(edge1);
//        edges.add(edge2);
//        edges.add(edge3);
//        edges.add(edge4);
//        edges.add(edge5);
//
//        List<Integer> ans = new Leetcode_1557().findSmallestSetOfVertices(5, edges);
//        System.out.println(ans);
//
//
//
//    }
//}
