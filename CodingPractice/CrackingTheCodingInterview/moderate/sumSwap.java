package moderate;

import java.util.HashSet;

public class sumSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in1 ={4,1,2,1,1,2};
		int[] in2 = {3,6,3,3};
		swapSumCheck(in1,in2);
		

	}

	private static void swapSumCheck(int[] in1, int[] in2) {
		// TODO Auto-generated method stub
		int sumA=0,sumB = 0,temp=0;
		HashSet<Integer> holdVals = new HashSet<Integer>();
		for(int i:in1)
			sumA+=i;
		for(int i:in2){
			sumB+=i;
			holdVals.add(i);
		}
		int val = getDifference(sumA,sumB);
		if(val == Integer.MAX_VALUE){
			System.out.println("Error with difference");
			return;
		}
		for(int i:in1){
			temp = i-val;
			if(holdVals.contains(temp)){
				System.out.println("Pair is: "+i+","+(i-val));
				break;
			}
		}
		
	}

	private static int getDifference(int sumA, int sumB) {
		// TODO Auto-generated method stub
		if((sumA-sumB)%2 == 0)
			return (sumA-sumB)/2;
		return Integer.MAX_VALUE;
	}

}
