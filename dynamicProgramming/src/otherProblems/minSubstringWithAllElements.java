package otherProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class minSubstringWithAllElements {
	
	///////Description////////
//	Shortest substring of S that contains all characters that occur in T.

	private static final String inputString= "bcbbdacbbaedbacbe";
	private static final String elementString ="ace";
	
	public static void main(String[] args) {
		int minValue = Integer.MAX_VALUE;
		int minLeft =0, minRight=0;
		int leftPtr =0, rightPtr=0;
		HashSet<Character> elements = new HashSet<Character>();
		HashSet<Character> checker = new HashSet<Character>();
		HashMap<Character,Integer> rightMost = new HashMap<Character,Integer>();
		initializeHashSet(elements);
		initializeHashSet(checker);
		while(rightPtr < (inputString.length())){
			//System.out.println(rightPtr);
			if(checker.contains(inputString.charAt(rightPtr))){
				
				elements.remove(inputString.charAt(rightPtr));
				rightMost.put(inputString.charAt(rightPtr), rightPtr);
				
				if(elements.isEmpty()){
					while(!checker.contains(inputString.charAt(leftPtr))||
							(checker.contains(inputString.charAt(leftPtr)) && (rightMost.get(inputString.charAt(leftPtr))>leftPtr)))
						leftPtr++;
					if(rightPtr-leftPtr<minValue){
						minValue = rightPtr-leftPtr+1;
						minLeft=leftPtr;
						minRight=rightPtr;
					}
					rightMost = new HashMap<Character,Integer>();	
					rightPtr++;
					leftPtr=rightPtr;
					initializeHashSet(elements);
				}else
					rightPtr++;
			}else
				rightPtr++;
		}
		System.out.println("Min Subsequence length: "+minValue+" Position: "+minLeft+" "+minRight);
		
	}
	
	private static void initializeHashSet(HashSet<Character> set){
		for(int i=0;i<elementString.length();i++)
			set.add(elementString.charAt(i));
	}

}
