package RecursionAndDynamic;

import java.util.Arrays;

public class coinChange {
	////////Get number of ways to get Sum
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {25,10,5,1};
		int sum = 100;
		int[] lookUp = new int[sum+1];
		Arrays.fill(lookUp, 0);
		System.out.println(numberOfWaysRecursive(sum,coins,0));

	}

	private static int numberOfWaysRecursive(int sum, int[] coins, int i) {
		// TODO Auto-generated method stub
//		if(sum<0 || i>=coins.length)
//			return 0;
//		if(sum==0)
//			return 1;
		if(i>=coins.length-1)
			return 1;
		int coin = coins[i];
		int val = 0;
		for(int j=0;j*coins[i]<=sum;j++){
			val+= numberOfWaysRecursive(sum-j*coins[i],coins,i+1);
		}
		return val;
	}

}
