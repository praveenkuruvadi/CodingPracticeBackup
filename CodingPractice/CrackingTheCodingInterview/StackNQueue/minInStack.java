package StackNQueue;

public class minInStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomStack stackTest = new CustomStack(5);
		try {
			System.out.println(stackTest.isEmpty());
			stackTest.push(3);
			stackTest.push(4);
			stackTest.push(2);
			stackTest.push(1);
			stackTest.printStack();
			System.out.println(stackTest.getMin());
			stackTest.pop();
			stackTest.pop();
			stackTest.printStack();
			System.out.println(stackTest.getMin());
			System.out.println(stackTest.peek());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " +e.getMessage());
		}

	}

}
