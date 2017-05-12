package redfin;

public class allPermutationsString {
	
	/////Backtracking Solution
	////String length n has n! permutations
	
	private static final String input= "ABCB";

	public static void main(String[] args) {
		permute(input,0,input.length()-1);

	}
	
	private static void permute(String input, int counter, int length){
		if(counter == length)
			System.out.println(input);
		else{
			for(int i = counter;i<=length;i++){
				input = swap(input,i,counter);
				permute(input,counter+1,length);
				input = swap(input,i,counter);
			}
			
		}
	}

	private static String swap(String input, int i, int counter) {
		char arr[] = input.toCharArray();
		char temp = arr[i];
		arr[i]=arr[counter];
		arr[counter] = temp;
		return String.valueOf(arr);
	}

}
