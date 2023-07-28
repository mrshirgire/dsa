package google;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRooms_252 {
    public static void main(String[] args) {
        int[][] arr = {
                        {8,11},
                        {17,20},
                        {17,20}
                    };
        System.out.println(canAttendMeetings(arr));
    }

    static class Meeting{
        int start;
        int end;
        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(int[][] intervals) {

        PriorityQueue<Meeting> pq = new PriorityQueue<>(((o1, o2) -> o1.start - o2.start));

        for(int i = 0; i<intervals.length; i++){
            int [] arr = intervals[i];
            pq.offer(new Meeting(arr[0], arr[1]));
        }

        int end = 0;
        while(!pq.isEmpty()){
            Meeting meeting = pq.poll();

            if(meeting.start<end) return false;
            end = meeting.end;
        }

        return true;
    }
}
