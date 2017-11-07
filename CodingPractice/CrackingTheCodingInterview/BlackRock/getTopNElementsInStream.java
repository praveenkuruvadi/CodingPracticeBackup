package BlackRock;

class minHeap{
	int[] heap;
	int currSize;
	public minHeap(int size){
		this.heap = new int[size];
		this.currSize = 0;
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
	
	public void insert(int i) throws Exception{
		if(this.currSize>=this.heap.length)
			throw new Exception("Full Heap");
		int temp = this.currSize;
		heap[this.currSize++] = i;
		int parent = temp/2;
		while(parent>=0 && this.heap[parent]>this.heap[temp]){
			swap(parent,temp);
			temp = parent;
			parent = temp/2;
		}
	}
	
	public int getMin() throws Exception{
		if(currSize == 0)
			throw new Exception("Empty heap");
		int elem = this.heap[0];
		this.heap[0] = this.heap[currSize-1];
		this.currSize--;
		Heapify(0);
		return elem;
	}
	
	private void Heapify(int i) {
		// TODO Auto-generated method stub
		int left = 2*i+1;
		int right = 2*i+2;
		int smallest = i;
		if(left<this.currSize && this.heap[left]<this.heap[smallest])
			smallest = left;
		if(right<this.currSize && this.heap[right]<this.heap[smallest])
			smallest = right;
		if(i != smallest){
			swap(i,smallest);
			Heapify(smallest);
		}
	}

	public int[] getHeap(){
		return this.heap;
	}
	
	public void printHeap(){
		System.out.println("");
		for(int i:this.heap)
			System.out.print(i+" ");
	}

	private void swap(int parent, int temp) {
		// TODO Auto-generated method stub
		int tempVal = this.heap[parent];
		this.heap[parent] = this.heap[temp];
		this.heap[temp] = tempVal;
	}
	
	public int pollTop(){
		return this.heap[0];
	}
	
}
public class getTopNElementsInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		int[] output = topElems(input,k);
	}

	private static int[] topElems(int[] input, int k) {
		// TODO Auto-generated method stub
		int[] output = new int[k];
		minHeap heap = new minHeap(k);
		try{
			for(int i=0;i<k;i++){
				heap.insert(input[i]);
			}
			//heap.printHeap();
			for(int i = k;i<input.length;i++){
				if(input[i]>heap.pollTop()){
					heap.getMin();
					heap.insert(input[i]);
				}
			}
			heap.printHeap();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return output;
	}

}