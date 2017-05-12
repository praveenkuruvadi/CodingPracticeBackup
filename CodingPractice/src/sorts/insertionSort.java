package sorts;

import java.util.ArrayList;
import sorts.timerClass;

public class insertionSort {
	private static int datasetSize =1000;
	private static int minimum = 1;
	private static int maximum = 1000;
	private static ArrayList<Integer> MainList;	
	
	public static void main(String[] args) {
		buildList();
		timerClass timer = new timerClass();
		timer.startTimer();
		ArrayList<Integer> sortedList = sort();
		timer.stopTimer();
		for(int i=0;i<sortedList.size();i++){
			System.out.println(sortedList.get(i)+" ");
		}
		System.out.println(timer.elapsedTime());
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
	
	private static ArrayList<Integer> sort(){
		ArrayList<Integer> sortedList = MainList;
		for(int i =0;i<sortedList.size();i++){
			int num = sortedList.get(i);
			int positionCounter = i-1;
			while(positionCounter>=0 && sortedList.get(positionCounter)>num){
				sortedList.set(positionCounter+1, sortedList.get(positionCounter));
				positionCounter--;
			}
			sortedList.set(positionCounter+1,num );
		}
		return sortedList;
	}

}
