package leetcode;

public class Leetcode_1295 {

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};

        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {

        int count = 0;

        for(int i = 0; i< nums.length; i++ ){

            if(isEven(nums[i]))
                count++;
        }

        return count;
    }

    public static boolean isEven(int num){

        return numberOfDigit(num) % 2 == 0 ;
    }

    public static int numberOfDigit(int num){

        if(num < 0)
            num = num * -1;

        return (int) (Math.log10(num) + 1);

        /*int count = 0;
        while(num != 0){
            count++;
            num = num / 10;
        }

        return count;*/
    }
}
