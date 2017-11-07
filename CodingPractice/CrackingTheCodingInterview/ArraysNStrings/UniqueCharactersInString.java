package ArraysNStrings;

import java.util.Arrays;

public class UniqueCharactersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Blah--";
		System.out.println(hasUniqueAlphabets(input));

	}

	private static boolean hasUniqueCharacters(String input) {
		// TODO Auto-generated method stub
		int[] holder = new int[256];
		Arrays.fill(holder, 0);
		for(char ch:input.toLowerCase().toCharArray())
			holder[(int)ch]++;
		for(int i:holder){
			if(i>1)
				return false;
		}
		return true;
	}
	private static boolean hasUniqueAlphabets(String input) {
		// TODO Auto-generated method stub
		int[] holder = new int[256];
		Arrays.fill(holder, 0);
		for(char ch:input.toLowerCase().toCharArray()){
			if(isLetterOrDigit(ch))
				holder[(int)ch]++;
		}
		for(int i:holder){
			if(i>1)
				return false;
		}
		return true;
	}
	
	private static boolean isLetterOrDigit(char c) {
	    return (c >= 'a' && c <= 'z') ||
	           (c >= 'A' && c <= 'Z') ||
	           (c >= '0' && c <= '9');
	}

}
