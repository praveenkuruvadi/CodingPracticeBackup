package RecursionAndDynamic;

import java.util.Arrays;

public class longestIncreasingSubsequence {
	
	public static void main(String[] args){
		int[] input = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(lis(input));
		System.out.println(lisSum(input));
	}

	private static int lisSum(int[] input) {
		// TODO Auto-generated method stub
		int[] temp = Arrays.copyOf(input, input.length);
		int j=0;
		for(int i=1;i<input.length;i++){
			j=0;
			while(j<i){
				if(input[j]<input[i])
					temp[i] = Math.max(temp[i], temp[j]+input[i]);
				j++;
			}
		}
		int max =Integer.MIN_VALUE;
		for(int i:temp)
			max = Math.max(max, i);
		return max;
	}

	private static int lis(int[] input) {
		// TODO Auto-generated method stub
		int[] temp = new int[input.length];
		Arrays.fill(temp, 1);
		int j=0;
		for(int i=1;i<input.length;i++){
			j=0;
			while(j<i){
				if(input[j]<input[i])
					temp[i] = Math.max(temp[i], temp[j]+1);
				j++;
			}
		}
		int max =Integer.MIN_VALUE;
		for(int i:temp)
			max = Math.max(max, i);
		return max;
		
	}

}
