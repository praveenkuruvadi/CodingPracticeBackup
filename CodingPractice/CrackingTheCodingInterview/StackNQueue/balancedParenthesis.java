package StackNQueue;

import java.util.Stack;

public class balancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "[(,)]{}3{[(2)()1]()}";
		
		System.out.println(isBalanced(input));

	}

	private static boolean isBalanced(String input) {
		// TODO Auto-generated method stub
		char[] arr = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i>arr.length;i++){
			char ch = arr[i];
			if(ch == '('|| ch=='{'||ch=='[')
				stack.push(ch);
			else if(ch == ')'|| ch=='}'||ch==']'){
				if(stack.isEmpty() || 
						(ch == ')' && stack.peek() != '(') ||
						(ch == '}' && stack.peek() != '{') ||
						(ch == ']' && stack.peek() != '['))
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty()?true:false;
	}

}
