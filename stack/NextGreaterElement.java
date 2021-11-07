package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public static List<Integer> nextGreaterToRight(int[] arr){

        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) ans.add(-1);

            else if(stack.peek() > arr[i]) ans.add(stack.peek());

            else if(stack.peek() <= arr[i]){
                while (!stack.isEmpty() && stack.peek()<= arr[i]){
                    stack.pop();
                }

                int e = stack.isEmpty() ? -1 : stack.peek();
                ans.add(e);
            }

            stack.push(arr[i]);

        }

        return  ans;
    }

    public static List<Integer> nextGreaterToLeft(int[] arr){
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< arr.length; i++){

            if(stack.isEmpty()) ans.add(-1);
            else if(stack.peek() > arr[i]) ans.add(stack.peek());
            else if(stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }

                int e = stack.isEmpty() ? -1 : stack.peek();
                ans.add(e);
            }

            stack.push(arr[i]);
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 4, 9, 4, 5, 8};
        List<Integer> nextGreaterToRight = nextGreaterToRight(arr);

        System.out.println("Next greater to right: ");
        for(int j = nextGreaterToRight.size() - 1; j>=0; j--){
            System.out.print(nextGreaterToRight.get(j)+" ");
        }

        int[] arr1 = {1, 3, 2, 4};
        List<Integer> nextGreaterToLeft = nextGreaterToLeft(arr1);

        System.out.println("\nNext greater to left: ");

        for(int i = 0; i < nextGreaterToLeft.size(); i++){
            System.out.print(nextGreaterToLeft.get(i)+" ");
        }






    }
}
