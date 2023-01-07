package graph;

public class LC_1319 {
    int[] size;
    int[] parent;
    int extraEdges = 0;
    public int makeConnected(int n, int[][] connections) {

        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }

        for(int[] conn: connections){
            union(conn[0], conn[1]);
        }

        int componentCount = 0;
        for(int i = 0; i < n; i++ ){
            if(parent[i] == i){
                componentCount++;
            }
        }

        return extraEdges >= (componentCount - 1) ?  (componentCount - 1) : -1;
    }

    public void union(int u, int v){
        int uParent = findParentBySize(u);
        int vParent = findParentBySize(v);

        if(uParent == vParent){
            extraEdges++;
            return;
        }

        if(size[uParent] < size[vParent]){
            parent[uParent] = vParent;
            size[vParent] = size[vParent] + size[uParent];
            return;
        }

        parent[vParent] = uParent;
        size[uParent] = size[vParent] + size[uParent];
    }

    public int findParentBySize(int node){
        if(parent[node] == node) return node;

        return parent[node] = findParentBySize(parent[node]);
    }
}
