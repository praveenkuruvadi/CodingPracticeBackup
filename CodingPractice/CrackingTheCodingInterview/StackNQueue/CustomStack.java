package StackNQueue;

import java.util.Arrays;
import java.util.Stack;

public class CustomStack {
	
	private int[] stack;
	private int stackPtr;
	private int min;
	private Stack<Integer> minStack;
	
	public CustomStack(int size){
		this.stack = new int[size];
		this.stackPtr = -1;
		this.minStack = new Stack<Integer>();
		this.min = Integer.MAX_VALUE;
	}
	
	public void push(int data) throws Exception{
		if(this.stackPtr == this.stack.length-1)
			throw new Exception("Stack if Full");
		this.stack[++this.stackPtr] = data;
		if(data < this.min)
			this.min = data;
		if(this.minStack.isEmpty() || this.minStack.peek()>=data)
			this.minStack.push(data);
	}
	
	public int pop() throws Exception{
		if(this.stackPtr<0)
			throw new Exception("Stack is Empty");
		if(this.stack[this.stackPtr] == this.min)
			resetMin();
		if(this.stack[this.stackPtr] == this.minStack.peek())
			this.minStack.pop();
		return this.stack[this.stackPtr--];
	}
	
	public int peek() throws Exception{
		if(this.stackPtr<0)
			throw new Exception("Stack is Empty");
		return this.stack[this.stackPtr];
	}
	
	public boolean isEmpty(){
		return this.stackPtr<0?true:false;
	}
	
	public void printStack() throws Exception{
		if(this.stackPtr<0)
			throw new Exception("Stack is Empty");
		System.out.println("");
		for(int i=0;i<=this.stackPtr;i++){
			System.out.print(this.stack[i]+" ");
		}
		System.out.println("");
	}
	
	public int getMin() throws Exception{
		if(this.stackPtr<0)
			throw new Exception("Stack is Empty");
		return this.minStack.peek();
	}

	private void resetMin() {
		// TODO Auto-generated method stub
		int temp = Integer.MAX_VALUE;
		for(int i=0;i<=this.stackPtr-1;i++){
			if(this.stack[i]<temp)
				temp = this.stack[i];
		}
		this.min = temp;
	}

}
