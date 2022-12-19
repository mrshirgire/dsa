package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode_146 {

    public static void main(String[] args) {

        //["LRUCache","get",  "put",  "get", "put",  "put",  "get",  "get"]
        //[[2],        [2],   [2,6],  [1],   [1,5],  [1,2],  [1],    [2]]
        //Output:    [ -1,    null,   -1,    null,   null,   2,      -1  ]
        //Expected:  [ -1,    null,   -1,    null,   null,   2,       6  ]

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6);
        lRUCache.get(1);
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        lRUCache.get(1);
        lRUCache.get(2);

        //["LRUCache","put","put","put","put","get","get"]
        //[[2],       [2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache lRUCache1 = new LRUCache(2);

        lRUCache1.put(2, 1);
        lRUCache1.put(1, 1);
        lRUCache1.put(2, 3);
        lRUCache1.put(4, 1);
        lRUCache1.get(1);
        lRUCache1.get(2);



    }


}

class LRUCache{

    Map<Integer, Integer> cache;
    int capacity;

    LRUCache(int capacity){
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public void put(int key, int value){

        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
        }else if(this.cache.size() == capacity) {
            cache.remove(cache.entrySet().iterator().next().getKey());
            cache.put(key, value);
        }else{
            cache.put(key, value);
        }
    }

    public int get(int key){
        if(cache.containsKey(key)){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }

        return  -1;
    }
}
