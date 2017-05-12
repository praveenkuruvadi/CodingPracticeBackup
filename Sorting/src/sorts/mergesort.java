package sorts;

import java.util.ArrayList;
import sorts.mergeSortClass;

public class mergesort {
	private static int datasetSize =1000;
	private static int minimum = 1;
	private static int maximum = 1000;
	private static ArrayList<Integer> MainList;
	
	public static void main(String[] args) {
		buildList();
		timerClass timer = new timerClass();
		mergeSortClass ms = new mergeSortClass(MainList);
		timer.startTimer();
		ms.mergeSort(0, MainList.size()-1);
		timer.stopTimer();
		ArrayList<Integer> SortedList = ms.getSortedList();
		System.out.println("Final List");
		for(int i=0;i<SortedList.size();i++){
			System.out.println(SortedList.get(i));
		}
		System.out.println("Time:"+timer.elapsedTime());
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

