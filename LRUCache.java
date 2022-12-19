import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> map = new LinkedHashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            return;
        }else if(map.size() == capacity){

            Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
            map.remove(entry.getKey());
            map.put(key, value);
        }else{
            map.put(key, value);
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);

        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.put(4, 40);
        lruCache.put(5, 50);

        lruCache.put(6, 60);

        lruCache.get(1);

        lruCache.put(7, 70);

    }



}
