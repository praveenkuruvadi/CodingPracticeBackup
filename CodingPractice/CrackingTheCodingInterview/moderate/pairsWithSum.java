package moderate;

import java.util.Arrays;

public class pairsWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {14,13,9,-2,-1,0,3,5,7,6};
		int target = 12;
		pairsSumPrint(input,target);

	}

	private static void pairsSumPrint(int[] input, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(input);
		int left =0;
		int right = input.length-1;
		int temp = 0;
		while(left<right){
			temp = input[left]+input[right];
			if(temp == target){
				System.out.println("Pair: "+input[left]+","+input[right]);
				left++;right--;
			}
			else if(temp<target)
				left++;
			else
				right--;
		}
	}

}
