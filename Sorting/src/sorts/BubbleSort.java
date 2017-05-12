package sorts;
import java.util.ArrayList;
import java.util.Timer;
import sorts.timerClass;

public class BubbleSort {
	private static int datasetSize =1000;
	private static int minimum = 1;
	private static int maximum = 1000;
	private static ArrayList<Integer> MainList;

	public static void main(String[] args) {
		System.out.println("start");
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
		int temp = 0;
		for(int i=0;i<sortedList.size();i++){
			for(int j=1;j<sortedList.size();j++){
				if(sortedList.get(j-1)>sortedList.get(j)){
					temp = sortedList.get(j-1);
					sortedList.set(j-1, sortedList.get(j));
					sortedList.set(j, temp);
				}
			}
		}
		return sortedList;
	}

}
