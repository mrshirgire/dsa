package leetcode;

import java.util.*;
class ScheduleData {
    int startTime;
    int endTime;
    int profit;

    ScheduleData(int startTime, int endTime, int profit){
        this.startTime =startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getProfit() {
        return profit;
    }
}

public class LeetCode_1235 {




    public static void main(String[] args) {

        LeetCode_1235 obj = new LeetCode_1235();

        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        //System.out.println(obj.jobScheduling(startTime,  endTime,  profit));
        System.out.println(obj.jobScheduling_(startTime, endTime, profit));
    }

    private int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<ScheduleData> scheduleDataList  = new ArrayList<>();

        for(int i = 0; i < startTime.length; i++){
            ScheduleData scheduleData = new ScheduleData(startTime[i], endTime[i], profit[i]);
            scheduleDataList.add(scheduleData);
        }

        Collections.sort(scheduleDataList, Comparator.comparingInt(sched -> sched.endTime));

        return -1;
    }

    public int jobScheduling_(int[] st, int[] et, int[] pf) {
        int n = st.length, jobs[][] = new int[n][3], res = 0;
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{st[i], et[i], pf[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0); // endtime, profit overall;
        for (int[] j : jobs) {
            int profit = map.floorEntry(j[0]).getValue() + j[2];
            if (profit > map.lastEntry().getValue()) map.put(j[1], profit);
        }
        return map.lastEntry().getValue();
    }
}
