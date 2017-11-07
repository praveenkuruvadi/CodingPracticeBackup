package TreesNGraphs;

public class heapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxHeap heap = new maxHeap(10);
		try {
			heap.insert(3);
			heap.insert(2);
			heap.insert(15);
			heap.insert(5);
			heap.insert(4);
			heap.insert(45);
			heap.printHeap();
			while(!heap.isEmpty())
				System.out.println(heap.extractMax());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
