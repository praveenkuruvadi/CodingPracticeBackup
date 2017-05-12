package StringMatching;

import java.util.ArrayList;

public class KMPMatch {

	private static final String input ="abxabcabcaby";
	private static final String pattern="abcaby";
	////Efficiency- O(m+n) Preprocess time = O(m)
	public static void main(String[] args) {
		int[] prefixFunction = preProcess();
		System.out.println("Prefix Data:");
		for(int i: prefixFunction)
			System.out.println(i);
		
		System.out.println("Match points:");
		ArrayList<Integer> matchPoints = kmpMatch(prefixFunction);
		for(int i:matchPoints)
			System.out.println(i);

	}
	
	///Populate prefix data- O(m)
	private static int[] preProcess(){
		int patternLen  =pattern.length();
		int[] prefixFunction = new int[pattern.length()];
		prefixFunction[0]=0;
		int matchCount =0;
		for(int i=1;i<pattern.length();i++){
			while(matchCount>0 && (pattern.charAt(matchCount)!=pattern.charAt(i)))
				matchCount = prefixFunction[matchCount-1];
			if(pattern.charAt(i)==pattern.charAt(matchCount)){
				matchCount++;
				prefixFunction[i]=matchCount;
			}
		}
		return prefixFunction;
	}
	
	private static ArrayList<Integer> kmpMatch(int[] prefixFunction){
		int matchCounter=0;
		ArrayList<Integer> matchPoints = new ArrayList<Integer>();
		for(int i=1;i<input.length();i++){
			while(matchCounter>0 && input.charAt(i)!=pattern.charAt(matchCounter))
				matchCounter = prefixFunction[matchCounter-1];
			if(pattern.charAt(matchCounter)==input.charAt(i))
				matchCounter++;
			if(matchCounter == pattern.length())
				matchPoints.add(i-pattern.length()+1);
		}
		return matchPoints;
		
	}

}
