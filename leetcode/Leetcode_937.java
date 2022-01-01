package leetcode;

import java.util.Arrays;

public class Leetcode_937 {

    public static void main(String[] args) {

        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(reorderLogFiles(input));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2)->{
            String[] l1 = log1.split(" ", 2);
            String[] l2 = log2.split(" ", 2);

            boolean l1IsDigit = Character.isDigit(l1[1].charAt(0));
            boolean l2IsDigit = Character.isDigit(l2[1].charAt(0));

            if(!l1IsDigit && !l2IsDigit){
                int comp = l1[1].compareTo(l2[1]);
                return  comp == 0 ? l1[0].compareTo(l2[0]) : comp;
            }else if(l1IsDigit && !l2IsDigit){
                return -1;
            }else if(!l1IsDigit && l2IsDigit){
                return 1;
            }else{
                return 0;
            }
        });

        return logs;

    }
}
