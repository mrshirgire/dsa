package stack;

import java.util.*;

public class StockSpan {

    public static void main(String[] args) {

        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        List<Integer> ans = getConsecutiveSmallerNumbers(arr);

        System.out.println("\nNext greater to left: ");

        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    private static List<Integer> getConsecutiveSmallerNumbers(int[] arr) {

        List<Integer> greaterNumberIndex = new ArrayList<>();
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

        for(int i = 0; i< arr.length; i++){

            if(stack.isEmpty()) greaterNumberIndex.add(-1);

            else if(stack.peek().getKey() > arr[i]) greaterNumberIndex.add(stack.peek().getValue());
            else if(stack.peek().getKey() <=  arr[i]){
                while (!stack.isEmpty() && stack.peek().getKey() <= arr[i]){
                    stack.pop();
                }

                int index = stack.isEmpty()? -1 : stack.peek().getValue();
                greaterNumberIndex.add(index);
            }

            stack.push(Map.entry(arr[i], i));
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< arr.length; i++){
            ans.add(i-greaterNumberIndex.get(i));
        }

        return  ans;

    }


}
