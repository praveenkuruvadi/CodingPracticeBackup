package redfin;

public class HashMapCustom {
	private static int capacity = 1024;
	private static entryCustom table[];
	
	public HashMapCustom(){
		this.table = new entryCustom[capacity];
	}
	public HashMapCustom(int capacity){
		this.capacity = capacity;
		this.table = new entryCustom[capacity];
	}
	
	public void put(int key,int val){
		int index = hashcode(key);
		entryCustom entry = new entryCustom(key,val);
		if(table[index]==null)
			table[index]=entry;
		else{
			entryCustom curr = table[index];
			while(curr.getNext()!=null){
				if(curr.getKey()==entry.getKey()){
					curr.setValue(entry.getValue());
					break;
				}else if(curr.getNext()== null){
					curr.setNext(entry);
				}else
					curr=curr.getNext();
			}
		}
	}
	
	public int get(int key){
		int index =hashcode(key);
		if(table[index]==null)
			return -1;
		else{
			entryCustom curr = table[index];
			while(curr!=null){
				if(curr.getKey()==key)
					return curr.getValue();
				curr=curr.getNext();
			}
			return-1;
		}
	}
	
	public void remove(int key){
		int index = hashcode(key);
		if(table[index]==null)
			return;
		else{
			entryCustom curr =table[index];
			if(curr.getKey()==key){
				if(curr.getNext()==null)
					table[index]=null;
				else
					table[index]=curr.getNext();
			}else{
				while(curr.getNext().getKey()!=key)
					curr=curr.getNext();
				curr=curr.getNext().getNext();
			}
		}
	}
	private int hashcode(int key){
		//TODO
		return 0;
	}

}

class entryCustom{
	private int key;
	private int value;
	private entryCustom next;
	
	public entryCustom(int k, int v){
		this.key= k;
		this.value = v;
		this.next = null;
	}
	
	public entryCustom(int k, int v,entryCustom next){
		this.key= k;
		this.value = v;
		this.next = next;
	}
	
	public int getKey(){
		return this.key;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int val){
		this.value = val;
	}
	public entryCustom getNext(){
		return this.next;
	}
	
	public void setNext(entryCustom next){
		this.next = next;
	}
}