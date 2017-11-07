package LinkedLists;

import java.util.HashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);
		linkedList list = new linkedList(head);
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(1);
		list.add(1);
		list.traverseList();
		removeDuplicates(head,list);
		list.traverseList();
	}

	private static void removeDuplicates(Node head, linkedList list) {
		// TODO Auto-generated method stub
		if(head.getNext() == null)
			return;
		HashSet<Integer> set = new HashSet<Integer>();
		
		Node prev = null;
		Node curr = head;
		while(curr != null){
			int val = curr.getData();
			if(set.contains(val)){
				prev.setNext(curr.getNext());
				curr = curr.getNext();
			}
			else{
				set.add(val);
				prev = curr;
				curr = curr.getNext();
			}
		}
	}
}
