package leetcode;

//981. Time Based Key-Value Store

import javax.xml.crypto.Data;
import java.util.*;



public class LeetCode_981 {

    class TimeStampData {
        int timestamp;
        String value;

        TimeStampData(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<TimeStampData>> map;
    public LeetCode_981() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        List<TimeStampData> timeStampDataList =  null;
        if (!this.map.containsKey(key)){
            timeStampDataList = new ArrayList<>();
            timeStampDataList.add(new TimeStampData(timestamp, value));
            map.put(key, timeStampDataList);
        }else{
            this.map.get(key).add(new TimeStampData(timestamp, value));
        }
    }

    public String get(String key, int timestamp) {

        if (!this.map.containsKey(key)) return "";

        List<TimeStampData> list = this.map.get(key);

        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (list.get(mid).timestamp == timestamp)
                return list.get(mid).value;

            if(timestamp > list.get(mid).timestamp)
                start = mid + 1;
            else
                end = mid - 1;

        }
        return "";
    }



    public static void main(String[] args) {

        LeetCode_981 leetCode_981 = new LeetCode_981();
        leetCode_981.set("love","high",10);
        leetCode_981.set("love","low",20);
        System.out.println(leetCode_981.get("love",5));
        System.out.println(leetCode_981.get("love",10));
        System.out.println(leetCode_981.get("love",15));
        System.out.println(leetCode_981.get("love",20));
        System.out.println(leetCode_981.get("love",25));


    }


}
