package practice;

import java.util.HashSet;

public class returnAllSubsets {
//All subsets will be 2^(no of elements)
	
	public static void main(String[] args) {
		int[] val= {1,2,3,4,5};
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:val)
			set.add(i);
	}
	

}
