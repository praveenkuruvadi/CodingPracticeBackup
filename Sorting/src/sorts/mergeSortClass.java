package sorts;

import java.util.ArrayList;

public class mergeSortClass {
	
	private ArrayList<Integer> MainList;
	
	public mergeSortClass(ArrayList<Integer> MainList){
		this.MainList = MainList;
	}
	public ArrayList<Integer> getSortedList(){
		return this.MainList;
	}
	
	public void mergeSort(int left, int right) {
		int mid = (left+right)/2;
		if(left<right &&(right-left>=1)){
			mergeSort(left,mid);
			mergeSort(mid+1,right);
			merge(left,mid,right);
		}
	}



	private void merge(int left, int mid, int right) {
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		int startPoint=left;
		int i=left;
		int j= mid+1;
		while(i<=mid && j<=right){
			if(MainList.get(i)<=MainList.get(j)){
				sortedArray.add(MainList.get(i));
				i++;
			}else{
				sortedArray.add(MainList.get(j));
				j++;
			}
		}
		
		while(i<=mid){
			sortedArray.add(MainList.get(i));
			i++;
		}
		
		while(j<=right){
			sortedArray.add(MainList.get(j));
			j++;
		}
		
		int count=0;
		while(count<sortedArray.size()){
			MainList.set(startPoint, sortedArray.get(count));
			startPoint++;
			count++;
		}
	}

}
