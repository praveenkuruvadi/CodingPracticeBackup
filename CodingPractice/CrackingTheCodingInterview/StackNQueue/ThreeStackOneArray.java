package StackNQueue;

public class ThreeStackOneArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class StackArray{
	private int[] stack;
	private int stackPtr1;
	private int stackPtr2;
	private int stackPtr3;
	
	public StackArray(int size){
		this.stack = new int[size];
		this.stackPtr1 = 0;
		this.stackPtr2 = (size/3) +1;
		this.stackPtr3 = (2*size/3)+1;
	}
}