package LinkedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class minHeapNode{
	int data;
	int arr;
	int pos;
	public minHeapNode(int data, int arr,int pos){
		this.data = data;
		this.arr = arr;
		this.pos = pos;
	}
}

public class mergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] input = { {1, 3, 5, 7},
			            {2, 4, 6, 8},
			            {0, 9, 10, 11}};
		List<Integer> output = mergeArrays(input);
		System.lineSeparator();
		for(int i:output)
			System.out.print(i+" ");
	}

	private static List<Integer> mergeArrays(int[][] input) {
		// TODO Auto-generated method stub
		List<Integer> out = new ArrayList<Integer>();
		PriorityQueue<minHeapNode> minHeap = new PriorityQueue<minHeapNode>(1, new Comparator<minHeapNode>(){

			@Override
			public int compare(minHeapNode o1, minHeapNode o2) {
				// TODO Auto-generated method stub
				return o1.data-o2.data;
			}
		});
		for(int i=0;i<input.length;i++)
			minHeap.add(new minHeapNode(input[i][0],i,0));
		
		while(!minHeap.isEmpty()){
			minHeapNode elem = minHeap.remove();
			if(elem.pos+1<input[elem.arr].length)
				minHeap.add(new minHeapNode(input[elem.arr][elem.pos+1],elem.arr,elem.pos+1));
			out.add(elem.data);
		}
		return out;
	}

}
