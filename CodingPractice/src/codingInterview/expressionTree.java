package codingInterview;

import java.util.Stack;

public class expressionTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "(AB)C((DE)F) | R";
		System.out.println(process(test));

	}
	
	public static String process(String s){
		String[] exp = s.trim().split("\\|");
		String expTree = exp[0].trim();
		String op = exp[1].trim();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		if(op.equals("R")){
			for(char ch:expTree.toCharArray())
				stack.push(ch);
			while(!stack.isEmpty()){
				char item = stack.pop();
				if(item == '(')
					sb.append(')');
				else if(item == ')')
					sb.append('(');
				else
					sb.append(item);
			}
			return sb.toString();
		}else if(op.equals("S")){
			return simplifier(expTree);
		}
		return "Not Recognized operation";
	}

	private static String simplifier(String s) {
		StringBuilder sb = new StringBuilder();
		return null;
	}

}
