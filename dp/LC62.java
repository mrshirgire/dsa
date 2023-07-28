package dp;

public class LC62 {

    static int sf;
    static int ere;

    public static int uniquePaths(int m, int n) {

        int[][] vis =  new int[m][n];
        int[][] dirs = {{1, 0}, {0, 1}};
        return fun(0, 0, m, n, vis, dirs);
    }


    static int fun(int currRow, int currCol, int m, int n, int[][] vis,  int[][] dirs){
        vis[currRow][currCol] = 1;
        if(currRow == m - 1 && currCol == n - 1) {
            vis[currRow][currCol] = 0;
            return 1;

        }

        int sum = 0;
        for(int[] dir: dirs){

            int nextRow = currRow + dir[0];
            int nextCol = currCol + dir[1];

            if(nextRow < m && nextCol < n){
                if(vis[nextRow][nextCol] == 0){
                    sum+= fun(nextRow, nextCol, m, n, vis, dirs);
                }
            }
        }

        vis[currRow][currCol] = 0;
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
       // int m = 3; int n = 7;
        //System.out.println(uniquePaths( m,  n));

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();

        t2.start();

        t1.join();
        t2.join();



    }

    static void test(){
        System.out.println("kjfdsklj");
    }


    static class MyThread extends Thread{

        public void run(){

            for(int i = 0; i < 5; i++){
                System.out.println(currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
