package LinkedLists;

public class intersectionTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(1);
		Node head2 = new Node(4);
		linkedList list1 = new linkedList(head1);
		linkedList list2 = new linkedList(head2);
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(8);
		head2.setNext(head1.getNext().getNext().getNext());
		list1.traverseList();
		list2.traverseList();
		try {
			System.out.println(intersectionPoint(head1,head2).getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private static Node intersectionPoint(Node head1, Node head2) throws Exception{
		// TODO Auto-generated method stub
		int len1 =0,len2=0;
		Node curr1 = head1,curr2 = head2;
		while(curr1.getNext()!=null){
			len1++;
			curr1 = curr1.getNext();
		}
		while(curr2.getNext()!=null){
			len2++;
			curr2 = curr2.getNext();
		}
		if(curr1.hashCode() != curr2.hashCode()){
			System.out.println("Different Lists");
			return null;
		}
		
		curr1 = head1; curr2 = head2;
		int count = 1;
		if(len1>len2){
			while(count<=len1-len2){
				curr1 = curr1.getNext();
				count++;
			}
				
		}else if(len2>len1){
			while(count<=len2-len1){
				curr2 = curr2.getNext();
				count++;
			}
		}
		
		while(curr1.getNext()!= null && curr2.getNext()!= null){
			if(curr1.hashCode()==curr2.hashCode())
				return curr1;
			curr1 = curr1.getNext();
			curr2 = curr2.getNext();
		}
		throw new Exception("List traversal error");
	}

}
