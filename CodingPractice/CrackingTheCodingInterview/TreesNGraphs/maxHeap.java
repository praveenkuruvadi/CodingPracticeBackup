package TreesNGraphs;

public class maxHeap {
	private int size;
	private int[] heap;
	private int currSize;
	
	public maxHeap(int size){
		this.size = size;
		this.currSize = 0;
		this.heap = new int[size];
	}
	
	public int getParent(int i){
		return this.heap[i/2];
	}
	
	public int getLeftChild(int i){
		return this.heap[2*i+1];
	}
	
	public int getRightChild(int i){
		return this.heap[2*i+2];
	}
	
	public boolean isEmpty(){
		return this.currSize>0?false:true;
	}
	
	public void insert(int i) throws Exception
	{
		if(this.currSize>=this.size)
			throw new Exception("Heap is full");
		int tempSize = currSize;
		this.heap[currSize++] = i;
		int parent = tempSize/2;
		while(parent >=0 && this.heap[parent]<this.heap[tempSize]){
			swap(parent,tempSize);
			tempSize = parent;
			parent = tempSize/2;
		}
	}
	
	private void swap(int parent, int tempSize) {
		// TODO Auto-generated method stub
		int temp = this.heap[tempSize];
		this.heap[tempSize] = this.heap[parent];
		this.heap[parent] = temp;
		
	}
	
	private void maxHeapify(int i){
		int left = 2*i+1;
		int right = 2*i+2;
		int largest =i;
		if(left< this.currSize && this.heap[i]<this.heap[left])
			largest = left;
		if(right<this.currSize && this.heap[largest]<this.heap[right])
			largest =right;
		if(largest != i){
			swap(largest,i);
			maxHeapify(largest);
		}
	}

	public int extractMax() throws Exception{
		if(currSize == 0)
			throw new Exception("Empty heap");
		int elem = this.heap[0];
		this.heap[0] = this.heap[currSize-1];
		this.currSize--;
		maxHeapify(0);
		return elem;
	}
	
	public void printHeap(){
		System.out.println("");
		for(int i=0;i<this.currSize;i++)
			System.out.print(this.heap[i]+" ");
		System.out.println("");
	}
}
