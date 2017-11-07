package StackNQueue;

import java.util.Stack;

class minStack{
	private Stack<Integer> mainStack;
	private Stack<Integer> temp;
	
	public minStack(){
		this.mainStack = new Stack<Integer>();
		this.temp = new Stack<Integer>();
	}
	
	public void pushToStack(int val){
		if(this.temp.isEmpty() || val<=this.temp.peek())
			temp.push(val);
		mainStack.push(val);
	}
	
	public int popStack() throws Exception{
		if(mainStack.isEmpty())
			throw new Exception("Empty Stack");
		int elem = mainStack.pop();
		if(elem == temp.peek())
			temp.pop();
		return elem;
	}
	
	public int getMin() throws Exception{
		if(temp.isEmpty())
			throw new Exception("Empty Stack");
		return temp.peek();
	}
}

public class runningMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minStack stack = new minStack();
		
		try {
			stack.pushToStack(3);
			stack.pushToStack(5);
			System.out.println(stack.getMin());
			stack.pushToStack(2);
			stack.pushToStack(1);
			System.out.println(stack.getMin());
			stack.popStack();
			System.out.println(stack.getMin());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
