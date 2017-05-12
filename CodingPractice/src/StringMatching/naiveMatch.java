package StringMatching;

import java.util.ArrayList;

public class naiveMatch {
	
	private static final String input = "acaabccdaab";
	private static final String pattern= "aab";

	///Efficiency- O((n-m+1)m)
	public static void main(String[] args) {
		
		ArrayList<Integer> matchingIndex = new ArrayList<Integer>();
		int inputLen = input.length();
		int patternLen = pattern.length();
		for(int i =0;i<=inputLen-patternLen;i++){
			if(input.substring(i,i+patternLen).equals(pattern))
				matchingIndex.add(i);
		}
		
		if(matchingIndex.isEmpty())
			System.out.println("No match found");
		System.out.println("Matching indexes:");
		for(int i : matchingIndex)
			System.out.println(i);
		

	}

}
