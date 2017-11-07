package codingInterview;

import java.util.Arrays;

public class subArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,6};
		int sum = 7;
		System.out.println(bruteForce(input,sum));
		System.out.println(sortingMethod(input,sum));

	}

	private static boolean sortingMethod(int[] input, int sum) {
		Arrays.sort(input);
		int left=0;
		int right = 1;
		int tempSum =input[0];
		while(left<input.length&&right<input.length){
			if(tempSum == sum)
				return true;
			else{
				if(tempSum<sum){
					tempSum+=input[right];
					right++;
				}else if(tempSum>sum){
					tempSum -= input[left];
					left++;
				}
			}
		}
		return false;
	}

	private static boolean bruteForce(int[] input, int sum) {
		int tempSum = 0;
		for(int i=0;i<input.length;i++){
			tempSum = input[i];
			if(tempSum == sum)
				return true;
			for(int j=i+1;j<input.length;j++){
				tempSum+=input[j];
				if(tempSum == sum)
					return true;
			}
		}
		return false;
	}

}
