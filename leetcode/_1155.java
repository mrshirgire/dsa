package leetcode;

public class _1155 {

    public static void main(String[] args) {
        System.out.println(f( 4));
    }

    public static int f(int target){

        if(target ==0 ){
            return 1;
        }
        int count = 0;
        for(int i = 1; i<=target; i++){
            count = count + f(target - i);
        }

        return count;
    }
}
