package codingInterview;

import java.util.Comparator;
import java.util.PriorityQueue;
public class nThLargestSmallest {
	 //Brute force- sort list and get nth elem
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {7, 10, 4, 3, 20, 15};
		int n = 4;
		System.out.println(FindElem(input,n,"Smallest"));

	}

	private static int FindElem(int[] input, int n, String s) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1,new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg0-arg1;
			}
		});
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1-arg0;
			}
		});
		
		for(int i:input){
			minHeap.add(i);
			maxHeap.add(i);
		}
		for(int i=1;i<n;i++){
			minHeap.remove();
			maxHeap.remove();
		}
		if(s.equals("Largest"))
			return maxHeap.remove();
		else
			return minHeap.remove();
	}

}
