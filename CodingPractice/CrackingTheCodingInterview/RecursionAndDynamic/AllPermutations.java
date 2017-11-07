package RecursionAndDynamic;

import java.util.HashSet;

public class AllPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ABCB";
		HashSet<String> permutations = new HashSet<String>();
		getPermutations(input,0,input.length()-1,permutations);
		for(String s:permutations)
			System.out.println(s);

	}

	private static void getPermutations(String input, int curr, int len, HashSet<String> permutations) {
		// TODO Auto-generated method stub
		if(curr == len)
			permutations.add(input);
		for(int i=curr;i<=len;i++){
			input = swap(input,i,curr);
			getPermutations(input,curr+1,len,permutations);
			input = swap(input,i,curr);
		}
	}

	private static String swap(String input, int i, int j) {
		// TODO Auto-generated method stub
		char[] arr = input.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}

}
