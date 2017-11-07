package RecursionAndDynamic;

import java.util.ArrayList;
import java.util.HashSet;

public class PowerSet {
	///Find all subsets of a set
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		getPowerSet(set,output);
		for(ArrayList<Integer> out:output)
			System.out.println(out.toString());
	}

	private static void getPowerSet(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> output) {
		// TODO Auto-generated method stub
		int combi = (int)Math.pow(2, set.size());
		ArrayList<Integer> temp;
		for(int i=0;i<combi;i++){
			temp = new ArrayList<Integer>();
			for(int j=0;j<set.size();j++){
				if((i & (1<<j))>0)
					temp.add(set.get(j));
					
			}
			output.add(temp);
		}
	}

}
