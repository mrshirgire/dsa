package patterns;

public class Patterns {
    public static void main(String[] args) {
        //pattern1();
        //pattern2();
        //pattern3();
        pattern4(4);

    }

    private static void pattern1() {
        System.out.println();
        System.out.println("pattern 1: ");

        for (int row=0; row<5; row++){
            for (int col=0; col<=row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern2(){

        System.out.println();
        System.out.println("pattern 2: ");

        for (int row=0; row<5; row++){
            for (int col=0; col<5-row;col++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    private static void pattern3() {
        System.out.println();
        System.out.println("pattern 3: ");
        int n= 4;
        for (int row = 0; row < 2 * n; row++){
            int noOfCol = row > n? 2 * n - row : row;
            for(int col=0;col<noOfCol; col++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    private static void pattern4(int n) {

        for (int row=0; row<2*n-1; row++){

            for (int col =0; col<2*n-1; col++){
                int leftDistance = col;
                int rightDistance = (2*n-2) - col;
                int topDistance = row;
                int bottomDistance = (2*n-2) - row;

                int min = Math.min(bottomDistance, Math.min(topDistance, Math.min(leftDistance, rightDistance)));

                System.out.print(n - min+" ");

            }

            System.out.println();

        }
    }
}
