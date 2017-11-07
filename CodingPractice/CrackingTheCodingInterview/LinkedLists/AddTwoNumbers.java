package LinkedLists;

import java.util.Stack;

public class AddTwoNumbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(3);
		Node head2 = new Node(7);
		linkedList list1 = new linkedList(head1);
		list1.add(3);
		list1.add(5);
		linkedList list2 = new linkedList(head2);
		list2.add(8);
		list2.add(7);
		list1.traverseList();
		list2.traverseList();
		list1.traverseList(getSum(head1,head2));

	}

	private static Node getSum(Node head1, Node head2) {
		Node curr = new Node(0);
		Node currHead = curr;
		int carry = 0;
		while(head1!=null || head2!=null){
			int val = (head1.equals(null)?0:head1.getData()) + 
					(head2.equals(null)?0:head2.getData()) + 
					carry;
			carry = val/10;
			curr.setNext(new Node(val%10));
			curr =curr.getNext();
			if(!head1.equals(null))
				head1 = head1.getNext();
			if(!head2.equals(null))
				head2 = head2.getNext();
		}
		if(carry>0)
			curr.setNext(new Node(carry));
		return currHead.getNext();
	}

}
