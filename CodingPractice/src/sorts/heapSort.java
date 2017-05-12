package sorts;

import java.util.ArrayList;

public class heapSort {
	private static int datasetSize =10;
	private static int minimum = 1;
	private static int maximum = 100;
	private static ArrayList<Integer> MainList;
	private static ArrayList<Integer> sortedList;

	public static void main(String[] args) {
		buildList();
		timerClass timer = new timerClass();
		//System.out.println("After heapify");
		buildHeap();
		//for(int i=0;i<MainList.size();i++)
			//System.out.println(MainList.get(i));
		System.out.println("----------");
		heapSort();
		for(int i=0;i<MainList.size();i++)
			System.out.println(MainList.get(i));

	}
	
	private static void heapSort(){
		int temp =0;
		int heapSize = MainList.size()-1;
		for(int i=MainList.size()-1;i>=1;i--){
			temp =MainList.get(0);
			//System.out.println(temp);
			MainList.set(0, MainList.get(i));
			MainList.set(i, temp);
			maxHeapify(0,--heapSize);
		}
	}
	private static void buildHeap(){
		for(int i=(MainList.size()-1)/2;i>=0;i--)
			maxHeapify(i,MainList.size());
	}
	
	private static void maxHeapify(int i,int size){
		
		int left =2*i;
		int right =2*i+1;
		int largest =i;
		if(left<=size && MainList.get(left)>MainList.get(i))
			largest=left;
		if(right<=size && MainList.get(right)>MainList.get(largest))
			largest =right;
		if(largest !=i){
			//System.out.println("heapify");
			int temp=MainList.get(largest);
			MainList.set(largest, MainList.get(i));
			MainList.set(i, temp);
			maxHeapify(largest,size);
		}
	}
	private static void buildList(){
		MainList = new ArrayList<Integer>();
		for(int i=0;i<datasetSize;i++){
			int randomNumber = minimum + (int)(Math.random() * maximum); 
			MainList.add(randomNumber);
			//System.out.println(randomNumber);
		}
		//System.out.println("----------");
	}

}
