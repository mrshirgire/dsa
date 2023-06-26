package graph;

public class LC_1791 {

    public static int findCenter(int[][] edges) {
        int n = edges.length;;
        int[] inDegree = new int[n + 2];
        for(int[] edge: edges){
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        int maxIndex = 1;
        int max = inDegree[1];
        for(int i = 2; i <= n + 1; i++){
            if(inDegree[i] > max){
                max = inDegree[i];
                maxIndex = i;
            }
        }

        return maxIndex;

    }

    public static void main(String[] args) {
        int[][] edges = {{1,18},{18,2},{3,18},{18,4},{18,5},{6,18},{18,7},{18,8},{18,9},{18,10},{18,11},{12,18},{18,13},{18,14},{15,18},{16,18},{17,18}};
        int ans = findCenter(edges);
        System.out.println(ans);
    }
}
