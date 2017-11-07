package LinkedLists;

import java.util.Stack;

public class linkedListPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);
		linkedList list = new linkedList(head);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(4);
		list.add(3);
		list.traverseList();
		try {
			System.out.println(checkPalindrome(head));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private static boolean checkPalindrome(Node head) throws Exception{
		Stack<Integer> stack = new Stack<Integer>();
		Node curr = head;
		Node fast = head;
		while(fast!=null && fast.getNext()!= null){
			stack.push(curr.getData());
			curr = curr.getNext();
			fast = fast.getNext().getNext();
		}
		if(fast!=null && fast.getNext() == null)
			curr = curr.getNext();
		while(curr!=null){
			if(stack.pop()!= curr.getData())
				return false;
			curr = curr.getNext();
		}
		return true;
	}

}
