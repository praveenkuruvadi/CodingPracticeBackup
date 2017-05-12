package redfin;

import java.util.Arrays;

public class tripletSumInArray {
	
	private static final int value = 14;
	private static int inputArray[] = {5, 2, 7, 8, 4, 3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Number of Triplets:"+tripletSum(inputArray,value));

	}
	
	private static int tripletSum(int[] inputArray, int value){
		Arrays.sort(inputArray);
		int k,count=0,currSum=0;
		for(int i=0;i<inputArray.length-2;i++){
			k= inputArray.length-1;
			for(int j=i+1;j<k;){
				currSum = inputArray[i]+inputArray[j]+inputArray[k];
				if(currSum == value){
					System.out.println("("+inputArray[i]+" "+inputArray[j]+" "+inputArray[k]+")");
					j++;k--;
					count++;
				}else if(currSum<value)
					j++;
				else
					k--;
			}
		}
		return count;
	}

}
