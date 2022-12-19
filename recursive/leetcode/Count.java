package recursive.leetcode;

public class Count {

    static int count = 0;

    public static void main(String[] args) {
        int number = 010;
        getCount(number);
        System.out.println(count);
    }

    public static void getCount(int number){
        if(number == 0 )
            return;

        if(number % 10 == 0)
            count++;

        getCount(number / 10);
    }
}
