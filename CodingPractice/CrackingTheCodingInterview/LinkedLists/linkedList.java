package LinkedLists;

public class linkedList {
	private static int size;
	private Node head;
	
	public linkedList(){
		this.size = 0;
		this.head = null;
	}
	
	public linkedList(Node head){
		this.size =1;
		this.head = head;
	}
	
	public int getsize(){
		return this.size;
	}
	
	public void add(int data){
		
		if(head==null){
			this.head = new Node(data);
			size++;
		}
		else{
			Node current =this.head;
			while(current.getNext() !=null)
				current=current.getNext();
			current.setNext(new Node(data));
			size++;
		}
	}

	public void add(int i,int data) throws Exception{
		if(i>size){
			System.out.println("Out of Bounds");
			throw new Exception();
		}else if(i==size){
			this.add(data);
			size++;
		}else if(i==0){
			Node newHead = new Node(data,this.head);
			this.head = newHead;
			size++;
		}else{
			int count=0;
			Node prev = this.head;
			Node current = prev.getNext();
			while(count!=i){
				prev=current;
				current = current.getNext();
				count++;
			}
			prev.setNext(new Node(data,current));
			size++;
		}
	}
	
	public void deleteAtPosition(int i) throws Exception{
		if(i>size){
			System.out.println("Out of Bounds");
			throw new Exception();
		}else if(i==size){
			Node prev =this.head;
			Node current = prev.getNext();
			while(current.getNext()!=null){
				prev=current;
				current= current.getNext();
			}
			prev.setNext(null);
			size--;
		}else if(i==0){
			this.head =head.getNext();
			size--;
		}else{
			int count=0;
			Node prev = this.head;
			Node current = prev.getNext();
			while(count!=i){
				prev=current;
				current = current.getNext();
				count++;
			}
			prev.setNext(current.getNext());
			size--;
		}
	}
	public void delete(int data) throws Exception{
		if(head.equals(null)){
			System.out.println("Empty List");
			throw new Exception();
		}else if(this.head.getData() == data){
			this.head = head.getNext();
			size--;
		}
		else{
			Node prev =head;
			Node current =head.getNext();
			boolean deleteflag =false;
			while(prev.getNext() !=null){
				if(current.getData() == data){
					prev.setNext(current.getNext());
					size--;
					deleteflag =true;
					break;
				}
				else if(current.getNext()==null && current.getData() == data){
					prev.setNext(null);
					size--;
					deleteflag =true;
					break;
				}
				prev = current;
				current = current.getNext();
			}
			if(!deleteflag)
				System.out.println("Data not found");
		}	
	}
	
	public void traverseList(){
		if(head.equals(null))
			System.out.println("Empty List");
		else{
			Node current = head;
			while(current.getNext() != null){
				System.out.print(current.getData()+"->");
				current = current.getNext();
			}
			System.out.print(current.getData());	
			System.out.println("");
		}
	}
	
	public static void traverseList(Node currentNode){
		if(currentNode.equals(null))
			System.out.println("Empty List");
		else{
			Node current = currentNode;
			while(current.getNext() != null){
				System.out.print(current.getData()+"->");
				current = current.getNext();
			}
			System.out.print(current.getData());	
			System.out.println("");
		}
	}

}
