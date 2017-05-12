package sorts;

import java.util.ArrayList;

public class quickSort {

	private static int datasetSize =10;
	private static int minimum = 1;
	private static int maximum = 100;
	private static ArrayList<Integer> MainList;

	public static void main(String[] args) {
		buildList();
		timerClass timer = new timerClass();
		timer.startTimer();
		quicksort(0,MainList.size()-1);
		timer.stopTimer();
		for(int i=0;i<MainList.size();i++){
			System.out.println(MainList.get(i));
		}
		System.out.println("Time:"+timer.elapsedTime());

	}

	private static void quicksort(int start, int end){
		int pivot = MainList.get((start+end)/2);
		int left =start;
		int right = end;
		do{
			while(MainList.get(right)>pivot)
				right--;
			while(MainList.get(left)<pivot)
				left++;
			
			if(left<=right){
				int temp =MainList.get(left);
				MainList.set(left, MainList.get(right));
				MainList.set(right, temp);
				right--;left++;
			}
		}while(right>=left);
		
		if(start<right)
			quicksort(start,right);
		if(left<end)
			quicksort(left,end);
		
	}
	private static void buildList(){
		MainList = new ArrayList<Integer>();
		for(int i=0;i<datasetSize;i++){
			int randomNumber = minimum + (int)(Math.random() * maximum); 
			MainList.add(randomNumber);
			System.out.println(randomNumber);
		}
		System.out.println("----------");
	}
}
