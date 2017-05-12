package leetCodeEasy;

import java.util.Stack;

public class parenthesisCheck {

	public static void main(String[] args) {
		String s =  "()";
		boolean x = isValid(s);

	}
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if( c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(stack.isEmpty()|| stack.pop() != c)
                return false;
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }


}
