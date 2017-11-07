package LinkedLists;

public class KthFromLast {
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
			getFromLast(9,head);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private static void getFromLast(int k, Node head) throws Exception {
		// TODO Auto-generated method stub
		Node curr = head;
		int count =0;
		while(curr!=null){
			if(count==k)
				break;
			curr = curr.getNext();
			count++;
		}
		if(count<k)
			throw new Exception("K is out of range");
		Node prev = head;
		while(curr!= null){
			curr= curr.getNext();
			prev = prev.getNext();
		}
		System.out.println(k+" From last is: "+prev.getData());
	}

}
