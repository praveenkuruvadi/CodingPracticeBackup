package ArraysNStrings;

public class CheckTwoStringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1 ="Praveen";
		String input2 ="neevarp";
		System.out.println(isPermutation(input1,input2));

	}

	private static boolean isPermutation(String input1, String input2) {
		// TODO Auto-generated method stub
		int[] holder = new int[26];
		for(char ch:input1.toLowerCase().toCharArray()){
			if(isLetterOrDigit(ch))
				holder[(int)(ch-'a')]++;
		}
		
		for(char ch:input2.toLowerCase().toCharArray()){
			if(isLetterOrDigit(ch))
				holder[(int)(ch-'a')]--;
		}
		for(int i:holder){
			if(i>0)
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
