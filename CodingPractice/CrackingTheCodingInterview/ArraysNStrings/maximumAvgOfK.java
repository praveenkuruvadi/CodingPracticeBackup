package ArraysNStrings;

public class maximumAvgOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 12, -5, -6, 50, 3};
		int k = 4;
		System.out.println(maxSubArray(input,k));
	}

	private static float maxSubArray(int[] input, int k) {
		// TODO Auto-generated method stub
		int[] sumSoFar = new int[input.length];
		int sum=0;
		for(int i=0;i<input.length;i++){
			sum+=input[i];
			sumSoFar[i] = sum;
		}
		float maxAvg = Integer.MIN_VALUE;
		for(int i=k-1;i<input.length;i++){
			maxAvg = Math.max(maxAvg, (sumSoFar[i]-(i-k>0?sumSoFar[i-k]:0))/(float)k);
		}
		return maxAvg;
	}

}
