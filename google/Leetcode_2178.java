package google;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_2178 {

    public static void main(String[] args) {
       Leetcode_2178 obj = new Leetcode_2178();
        System.out.println(obj.maximumEvenSplit(28));
    }

    public List<Long> maximumEvenSplit(int finalSum){

        if(finalSum% 2 !=0) {
            return new ArrayList<>();
        }

        List<Long> ans = new ArrayList<>();
        long n = 2;
        long curSum = 0;
        while(curSum + n <= finalSum){
             ans.add(n);
             curSum = curSum+ n;
             n = n + 2;
         }

         //ans.add(ans.get(0)+(finalSum-curSum));
         return ans;
    }
}
