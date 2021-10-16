public class AdjGraph {

    private static int[][] adjMatrix= new int[5][5];

    public static void main(String[] args) {
        /*
        *   0---1
        *   |     \
        *   |      4
        *   |     /
        *   2---3
        *
        * */

        init();
        print();
        addEdge(0, 1);
        addEdge(1, 0);
        addEdge(0, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 2);
        addEdge(1, 4);
        addEdge(4, 1);
        addEdge(3, 4);
        addEdge(4, 3);
        System.out.println();
        print();

    }

    private static void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
    }


    public static void init(){
        for(int i=0; i<adjMatrix.length; i++){
            for(int j=0;j<adjMatrix[i].length; j++){
                     adjMatrix[i][j] = 0;
            }
        }
    }

    public static void print(){
        for(int i=0; i<adjMatrix.length; i++){
            for(int j=0;j<adjMatrix[i].length; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }

            System.out.println();
        }
    }

}
