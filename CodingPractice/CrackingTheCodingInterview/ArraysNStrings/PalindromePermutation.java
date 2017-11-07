package ArraysNStrings;

import java.util.Arrays;

public class PalindromePermutation {
	//Check if a string is a permutation of its palindrome

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Tact Cot";
		System.out.println(isPalindromePermute(input));

	}

	private static boolean isPalindromePermute(String input) {
		// TODO Auto-generated method stub
		int[] holder = new int[26];
		Arrays.fill(holder, 0);
		for(char ch:input.toLowerCase().toCharArray()){
			if(isLetterOrDigit(ch))
				holder[(int)(ch-'a')]++;
		}
		boolean hasOdd = false;
		for(int i:holder){
			if(i%2!=0 && !hasOdd)
				hasOdd = true;
			else if(i%2!=0)
				return false;
		}
		return true;
	}
	
	private static boolean isLetterOrDigit(char c) {
	    return (c >= 'a' && c <= 'z') ||
	           (c >= 'A' && c <= 'Z');
	}

}
