package LinkedLists;

public class deleteMiddle {

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
		try {
			deleteMid(head);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		list.traverseList();
	}

	private static void deleteMid(Node head) throws Exception {
		// TODO Auto-generated method stub
		if(head.getNext() == null)
			return;
		
		Node prev = head;
		Node fast = head;
		while(fast.getNext().getNext()!=null){
			prev = prev.getNext();
			fast = fast.getNext().getNext();
		}
		prev.setNext(prev.getNext().getNext());
	}

}
