package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesOrderedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list1 = {1,2,3,4,5,7,8};
		int[] list2 = {3,4,6,8,9};
		
		System.out.println(duplicates(list1,list2).size());

	}

	private static List duplicates(int[] list1, int[] list2) {
		// TODO Auto-generated method stub
		int i=0,j=0;
		List<Integer> outList = new ArrayList<Integer>();
		while(i<list1.length && j<list2.length){
			if(list1[i]==list2[j]){
				outList.add(list1[i]);
				i++;j++;
			}else if(list1[i]<list2[j]){
				i++;
			}else if(list1[i]>list2[j]){
				j++;
			}
		}
		return outList;
	}

}
