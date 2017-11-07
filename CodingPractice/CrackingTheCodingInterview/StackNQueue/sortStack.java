package StackNQueue;

import java.util.Stack;

public class sortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> inputStack = new Stack<Integer>();
		inputStack.push(3);
		inputStack.push(4);
		inputStack.push(1);
		inputStack.push(2);
		sortStack(inputStack);
	}

	private static void sortStack(Stack<Integer> inputStack) {
		// TODO Auto-generated method stub
		Stack<Integer> tempStack = new Stack<Integer>();
		int temp = 0;
		while(!inputStack.isEmpty()){
//			if(tempStack.isEmpty()){
//				tempStack.push(inputStack.pop());
//				System.out.println("Here1:"+tempStack.toString());
//			}
//			else{
//				while(!tempStack.isEmpty() && tempStack.peek()>inputStack.peek())
//						tempStack.push(inputStack.pop());
//				System.out.println("Here2:"+tempStack.toString());
//				temp = !inputStack.isEmpty()?inputStack.pop():temp;
//				while(!tempStack.isEmpty()  && tempStack.peek()<temp){
//					inputStack.push(tempStack.pop());
//				}
//				inputStack.push(temp);
//			}
			temp = inputStack.pop();
			while(!tempStack.isEmpty() && tempStack.peek()>temp)
				inputStack.push(tempStack.pop());
			
			tempStack.push(temp);
			
		}
		while(!tempStack.isEmpty())
			System.out.print(tempStack.pop()+" ");
	}

}
