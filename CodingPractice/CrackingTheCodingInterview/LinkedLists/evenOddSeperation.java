package LinkedLists;

public class evenOddSeperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);
		linkedList list = new linkedList(head);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(2);
		list.add(1);
		list.add(9);
		linkedList.traverseList(head);
		seperateEvenOddPos(head);
		linkedList.traverseList(head);
	}

	private static void seperateEvenOddPos(Node head) {
		// TODO Auto-generated method stub
		if(head.getNext() == null)
			return;
		Node p1 = head;
		Node p2 = head.getNext();
		Node connectNode = head.getNext();
		while(p2 != null && p1 !=null){
			p1.setNext(p2.getNext());
			p1 = p1.getNext();
			p2.setNext(p1.getNext());
			p2 = p2.getNext();
		}
		p1.setNext(connectNode);
	}

}
