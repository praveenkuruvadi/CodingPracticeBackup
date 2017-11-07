package RecursionAndDynamic;

import java.util.Stack;

public class towerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stackA = new Stack<Integer>();
		stackA.add(4);
		stackA.add(3);
		stackA.add(2);
		stackA.add(1);
		System.out.println(stackA.toString());
		Stack<Integer> stackB = new Stack<Integer>();
		Stack<Integer> stackC = new Stack<Integer>();
		solve(4,stackA,stackB,stackC);

	}
	
	private static void solve(int n, Stack<Integer> stackA, Stack<Integer> stackB, Stack<Integer> stackC){

	}
	
	private static boolean isSafe(Stack<Integer> stack, int elem){
		if(!stack.isEmpty() && stack.peek()<elem)
			return false;
		return true;
	}

}
