package codingInterview;


class Node {
    int data;
    Node next;
}
public class findCycleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private boolean hasCycle(Node head) {
	    if(head == null)
	        return false;
	    Node slow = head;
	    Node fast =head.next;
	    while(slow!=fast){
	        if(fast== null || fast.next == null)
	            return false;
	        slow = slow.next;
	        fast = fast.next.next;
	        
	            
	    }
	    return true;

	}

}
