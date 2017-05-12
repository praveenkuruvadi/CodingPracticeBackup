package otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/////Description///////
//Given a string (array
//of characters) of letters (a-z), remove duplicates of each character such that the result-
//ing string is the lexicographically smallest string.
//Ex 1: “bcabc” ! “abc”. Ex 2: “cbbadcdcac” ! “bacd”.


public class lexicographicSmallestDistinctSubsequence {
	
	private static HashMap<Character,Integer> rightmost;
	private static final String inputString ="cbbaedcdcac";
	
	public static void main(String[] args){
		
		int length = inputString.length();
		rightmost = new HashMap<Character,Integer>();
		Stack stack = new Stack();
		for(int i=0;i<inputString.length();i++){
			if(!rightmost.containsKey(inputString.charAt(i)))
				rightmost.put(inputString.charAt(i), i);
			else{
				if(rightmost.get(inputString.charAt(i))<i)
					rightmost.put(inputString.charAt(i), i);
			}
		}
//		for( char c: rightmost.keySet())
//			System.out.println(c+" "+rightmost.get(c));
		
		for(int i=0;i<inputString.length();i++){
			if(stack.empty())
				stack.push(inputString.charAt(i));
			else if(String.valueOf(inputString.charAt(i)).compareTo(stack.peek().toString())>0)
				stack.push(inputString.charAt(i));
			else if(String.valueOf(inputString.charAt(i)).compareTo(stack.peek().toString())<0){
				while(String.valueOf(inputString.charAt(i)).compareTo(stack.peek().toString())<0 && rightmost.get(stack.peek())>i){
					stack.pop();
					if(stack.empty())
						break;
				}
				if(stack.search(inputString.charAt(i))<0)
					stack.push(inputString.charAt(i));
			}
			else if(rightmost.get(inputString.charAt(i))==i && stack.search(inputString.charAt(i))<0)
				stack.push(inputString.charAt(i));
		}
		
		ArrayList<Character> list = new ArrayList<Character>(stack);
		System.out.println("Lexiographic distinct sequence:");
		for(char c:list)
			System.out.println(c);
		
	}

}
