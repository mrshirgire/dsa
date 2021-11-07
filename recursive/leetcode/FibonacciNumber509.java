package recursive.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber509 {
    static Map<Integer, Integer> map = new HashMap<>();

    public static int fib(int n) {

        if(n == 0 || n == 1)
            return n;

        if(map.get(n)!= null){
            return map.get(n);
        }else{
            int f = fib(n - 1) + fib(n - 2);
            map.put(n,f);
            return f;
        }

    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }



}
