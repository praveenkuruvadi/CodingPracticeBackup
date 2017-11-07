package codingInterview;

import java.util.Arrays;

public class longestIncreasingSubsequence {
	
	public static void main(String[] args){
		int[] input ={10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lis(input));
	}

	private static int lis(int[] input) {
		int[] temp = new int[input.length];
		Arrays.fill(temp, 1);
		int tempMaxVal = 0;
		for(int i=1;i<temp.length;i++){
			tempMaxVal = temp[i];
			for(int j=0;j<=i-1;j++){
				if(input[j]<input[i])
					tempMaxVal= Math.max(tempMaxVal, temp[i]+temp[j]);
			}
			temp[i]= tempMaxVal;
		}
		int max = Integer.MIN_VALUE;
		for(int i:temp){
			if(i>max)
				max=i;
		}
		return max;
	}

}
