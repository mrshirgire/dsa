package leetcode;

import java.util.Stack;

public class Leetcode_20 {
    public static void main(String[] args) {

        System.out.println( isValid("()"));
        System.out.println( isValid("()[]{}"));
        System.out.println( isValid("(]"));

    }

    public static boolean isValid(String s) {

        if(s.length() % 2 !=0) return false;

        Stack<Character> characterStack = new Stack<>();

        for(int i = 0; i<s.length(); i++){

            char c = s.charAt(i);

            if(characterStack.isEmpty()){
                characterStack.push(c);
            }else{
                char c1 = characterStack.peek();

                switch (c1){

                    case '(':
                        if(c == ')'){
                            characterStack.pop();
                        }else{
                            characterStack.push(c);
                        }
                    break;
                    case '[':
                        if(c == ']'){
                            characterStack.pop();
                        }else{
                            characterStack.push(c);
                        }
                        break;
                    case '{':
                        if(c == '}'){
                            characterStack.pop();
                        }else{
                            characterStack.push(c);
                        }
                        break;
                }
            }

        }

        if(characterStack.isEmpty())
            return true;
        else
            return false;

    }
}
