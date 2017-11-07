package BlackRock;

import java.util.Iterator;

class ListNode<T>{
	private T value;
	private ListNode next;
	
	public ListNode(T value, ListNode next){
		this.value = value;
		this.next = next;
	}
	
	public ListNode(T value){
		this.value = value;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ListNode getNext() {
		return this.next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}
public class LinkedListGeneric<T> implements Iterable{
	private ListNode head;
	private int size;
	
	public LinkedListGeneric(T value){
		this.head = new ListNode(value);
		this.size = 1;
	}
	
	public LinkedListGeneric(){
		this.head = null;
		this.size = 0;
	}
	
	public void TraverseList(){
		ListNode curr = this.head;
		while(curr!= null){
			System.out.print(curr.getValue()+"->");
			curr = curr.getNext();
		}
		System.out.println("");
	}
	
	public void insert(T value){
		if(this.head == null){
			this.head = new ListNode(value);
			this.size++;
		}else{
			ListNode curr = this.head;
			while(curr.getNext()!=null)
				curr = curr.getNext();
			curr.setNext(new ListNode(value));
			this.size++;
		}
	}
	
	public void deleteAtPosition(int i) throws Exception{
		if(i>this.size || this.size == 0)
			throw new Exception("Outside bounds");
		else{
			if(i == 1){
				this.head = this.head.getNext();
				this.size--;
			}else if(i==this.size){
				ListNode curr = this.head;
				while(curr.getNext().getNext()!=null)
					curr = curr.getNext();
				curr.setNext(null);
			}else{
				ListNode curr = this.head;
				int count =1;
				while(count<i-1){
					curr = curr.getNext();
					count++;
				}
				curr.setNext(curr.getNext().getNext());
			}
			this.size--;
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	class LinkedListIterator implements Iterator<T>{
		ListNode<T> current = null;
		@Override
		public boolean hasNext() {
			if(current == null && head != null){
				return true;
			}else if(current != null && current.getNext()!=null){
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			if(current == null && head!= null){
				current = head;
				return current.getValue();
			}else if(current != null){
				current = current.getNext();
				return current.getValue();
			}
			return null;
		}
	}

}
