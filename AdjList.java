
/*
         *   0---1
         *   |     \
         *   |      4
         *   |     /
         *   2---3
         *
         * */


class VertexNode {

    int data;
    VertexNode next;

    VertexNode(int data, VertexNode next ){
        this.data =data;
        this.next = next;
    }
}

public class AdjList {

    public static void main(String[] args) {

        VertexNode[] vertexNodes = new VertexNode[5];

        init(vertexNodes);
        addEdge(vertexNodes,0, 1);
        addEdge(vertexNodes,0, 2);
        addEdge(vertexNodes,1, 0);
        addEdge(vertexNodes,1, 4);
        addEdge(vertexNodes,2, 0);
        addEdge(vertexNodes,2, 3);
        addEdge(vertexNodes,3, 2);
        addEdge(vertexNodes,3, 4);
        addEdge(vertexNodes,4, 1);
        addEdge(vertexNodes,4, 3);

        print(vertexNodes);
    }

    private static void addEdge(VertexNode[] vertexNodes, int source, int destination) {

       VertexNode newNode = new VertexNode(destination, null);
       if(vertexNodes[source] == null){
           vertexNodes[source] = newNode;
        }else{
           VertexNode lastNode = vertexNodes[source];
           while (lastNode.next!=null){
               lastNode = lastNode.next;
           }

           lastNode.next = newNode;
       }
    }

    private static void init(VertexNode[] vertexNodes) {

        for(int i=0;i<vertexNodes.length; i++){
            vertexNodes[i] = null;
        }
    }

    private static void print(VertexNode[] vertexNodes){

        for(int i=0; i<vertexNodes.length; i++){
            VertexNode last = vertexNodes[i];
            System.out.print(i);
            while (last!=null){
                System.out.print("-->"+last.data);
                last = last.next;
            }
            System.out.println();
        }
    }








}
