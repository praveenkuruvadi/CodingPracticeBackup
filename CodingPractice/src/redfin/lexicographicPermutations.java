package redfin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class lexicographicPermutations {
	////Print all the permutations of a string in lexicographic order
	

	private static final String input= "caabbc";
	private static final String toCheck= "caabbc";
	public static void main(String[] args) {
		String orderedInput = sortLexicographic(input);
		
		//permuteLexicographic(orderedInput);
		permuteLexicographicGetRank(orderedInput,toCheck);
		

	}
	private static void permuteLexicographic(String input){
		Boolean isDone = Boolean.FALSE;
		int largest1,largest2;
		while(!isDone){
			largest1=-1;largest2=0;
			System.out.println(input);
			for(int i=0;i<input.length()-1;i++){
				if(input.charAt(i+1)-input.charAt(i)>0)
					largest1=i;
			}
			if(largest1==-1){
				isDone= Boolean.TRUE;
				System.out.println("Done");
				break;
			}
				
			for(int i=0;i<input.length();i++){
				if(input.charAt(largest1)<input.charAt(i))
					largest2=i;
			}
			input = swap(input,largest1,largest2);
			input = reverse(input,largest1);
		}
	}
	
	private static void permuteLexicographicGetRank(String input,String toCheck){
		Boolean isDone = Boolean.FALSE;
		int largest1,largest2;
		int rank =1;
		while(!isDone){
			largest1=-1;largest2=0;
			if(input.equals(toCheck)){
				System.out.println("Found at rank:"+rank);
				break;
			}
			
			for(int i=0;i<input.length()-1;i++){
				if(input.charAt(i+1)-input.charAt(i)>0)
					largest1=i;
			}
			if(largest1==-1){
				isDone= Boolean.TRUE;
				System.out.println("Not Found: Error");
				break;
			}
				
			for(int i=0;i<input.length();i++){
				if(input.charAt(largest1)<input.charAt(i))
					largest2=i;
			}
			input = swap(input,largest1,largest2);
			input = reverse(input,largest1);
			rank++;
		}
	}
	
	private static String reverse(String input, int largest1) {
		StringBuilder sb = new StringBuilder(input.substring(0, largest1+1));
		StringBuilder reverse = new StringBuilder(input.substring(largest1+1, input.length()));
		sb.append(reverse.reverse().toString());
		return sb.toString();
	}
	private static String swap(String input, int i, int j) {
		char arr[] = input.toCharArray();
		char temp = arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
	
	private static String sortLexicographic(String input){
		PriorityQueue<Character> sortInput = 
				new PriorityQueue<Character>(1, new Comparator<Character>(){
					@Override
					public int compare(Character char1, Character char2) {
						return char1.compareTo(char2);
					}
				});
		for(int i=0;i<input.length();i++)
			sortInput.add(input.charAt(i));
		StringBuilder sb = new StringBuilder();
		while(!sortInput.isEmpty())
			sb.append(sortInput.poll());
		return sb.toString();
	}


}
