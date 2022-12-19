package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode_1249 {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {

        Set<Integer> indexToBeRemoved = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == ')') {
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                     indexToBeRemoved.add(i);
                }
            }
        }

        while (!stack.isEmpty()){
                indexToBeRemoved.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length();i++){
            if(!indexToBeRemoved.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

}
