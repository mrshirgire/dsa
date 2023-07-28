package graph;

import java.util.HashSet;
import java.util.Set;

public class LC_827 {

    int[] size;
    int[] parent;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        size = new int[n * m];
        parent = new int[n * m];

        for(int i = 0; i < (m * n); i++){
            size[i] = 1;
            parent[i] = i;
        }

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 1){
                    int currNode = row * m + col;
                    for(int i = 0; i < dirs.length; i++ ){
                        int nextRow = row + dirs[i][0];
                        int nextCol = col + dirs[i][1];
                        if(nextRow >=0 && nextRow < n && nextCol >= 0 && nextCol < m){
                            if(grid[nextRow][nextCol] == 1){
                                int adjNode = nextRow * m + nextCol;
                                union(currNode, adjNode);
                            }
                        }
                    }
                }

            }
        }

        int ans = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 0){
                    Set<Integer> component = new HashSet<>();
                    for(int i = 0; i < dirs.length; i++){
                        int nextRow = row + dirs[i][0];
                        int nextCol = col + dirs[i][1];
                        if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){

                            if(grid[nextRow][nextCol] == 1){
                                int adjNode = nextRow * m + nextCol;
                                component.add(findParent(adjNode));
                            }
                        }
                    }

                    int totalSize = 0;
                    for(int parentNode: component){
                        totalSize += size[parentNode];
                    }
                    ans = Math.max(ans, totalSize + 1);
                }
            }
        }
        for(int cellNo = 0; cellNo < (n * m); cellNo++){
            ans = Math.max(ans, size[findParent(cellNo)]);
        }
        return ans;

    }

    public void union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);

        if(uParent == vParent) return;

        if(size[uParent] < size[vParent]){
            parent[uParent] = vParent;
            size[vParent] =  size[uParent] +  size[vParent];
            return;
        }

        parent[vParent] = uParent;
        size[uParent] =  size[vParent] +  size[uParent];
    }

    public int findParent(int node){
        if(parent[node] == node) return node;

        return parent[node] = findParent(parent[node]);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1},{1, 1}};
        int largeSize = new LC_827().largestIsland(grid);
        System.out.println(largeSize);
    }
}
