package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_13 {

    static Map<Character, Integer> map = new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public static void main(String[] args) {
        /*romanToInt("III");*/
        System.out.println(romanToInt("LVIII"));
        //System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        int i = s.length() - 1, prev = 0, val = 0, sum = 0;

        while (i>=0){
            val = map.get(s.charAt(i));
            if(prev != 0 && prev > val){
                sum = sum - val;
            }else{
                sum = sum + val;
            }

            prev = val;
            i--;
        }

        return sum;
    }



}
