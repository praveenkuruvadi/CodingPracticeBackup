package codingInterview;

public class palindromePermutation {

	public static void main(String[] args) {
		String toCheck = "atco cta";
		char[] characters=toCheck.replace(" ", "").toCharArray();
		int[] arr = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		int val =0,oddCount=0;
		for(char c: characters){
			val =Character.getNumericValue(c)-Character.getNumericValue('a');
			arr[val]++;
			if(arr[val]%2==0)
				oddCount--;
			else
				oddCount++;
		}
		System.out.println(oddCount<=1);
	}

}
