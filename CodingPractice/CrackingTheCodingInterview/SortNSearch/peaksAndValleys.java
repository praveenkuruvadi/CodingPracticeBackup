package SortNSearch;

import java.util.Arrays;

public class peaksAndValleys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5,8,6,2,3,4,6};
		sortPeakValley(input);
		for(int i:input)
			System.out.print(i+" ");
	}

	private static void sortPeakValley(int[] input) {
		// TODO Auto-generated method stub
		Arrays.sort(input);
		int temp =0;
		for(int i=2;i<input.length;i+=2){
			temp = input[i];
			input[i] = input[i-1];
			input[i-1] = temp;
		}
	}

}
