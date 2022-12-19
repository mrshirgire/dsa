package leetcode;

import java.util.*;


public class Leetcode_2034 {



    static Map<Integer, Integer> map = new LinkedHashMap<>();

    public static void update(int timestamp, int price) {
        map.put(timestamp, price);
    }

    public static int current() {
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        return entryList.get(entryList.size() -1).getValue();
    }

    public static int maximum() {
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2)-> obj2.getValue()- obj1.getValue());

        return entryList.get(0).getValue();

    }

    public static int minimum() {
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2)-> obj1.getValue()- obj2.getValue());

        return entryList.get(0).getValue();
    }

    public static void main(String[] args) {
        Leetcode_2034 leetcode_2034 = new Leetcode_2034();
        update(1, 10);
        update(2, 5);
        System.out.println(current());
        System.out.println(maximum());
        update(1,3);
        System.out.println(maximum());
        update(4,2);
        System.out.println(minimum());
    }
}
