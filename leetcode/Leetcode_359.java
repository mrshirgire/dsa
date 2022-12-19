package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Leetcode_359 {
    public static Map<String, Integer>  map = new HashMap<>();
    public static void main(String[] args) {

    }

    public boolean shouldPrintMessage(int timestamp, String message){

        map.entrySet()
                .removeIf(entry-> timestamp - entry.getValue()>=10);

        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return false;
        }else {
            return true;
        }
    }
}
