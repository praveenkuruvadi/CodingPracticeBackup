package SortNSearch;

import java.util.Arrays;
import java.util.Comparator;

class sortStrings implements Comparator<String>{
	
	public String sortString(String in){
		char[] ar = in.toCharArray();
		Arrays.sort(ar);
		return String.valueOf(ar);
	}
	public int compare(String a, String b){
		return sortString(a).compareTo(sortString(b));
	}
}
public class groupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagramsSort(input);
		for(String s:input)
			System.out.print(s+" ");

	}

	private static void groupAnagramsSort(String[] input) {
		// TODO Auto-generated method stub
		Arrays.sort(input,new sortStrings());
	}

}
