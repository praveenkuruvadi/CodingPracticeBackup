package coinChange;

import java.util.ArrayList;
import timerClass.timer;
public class coinChange {
	
	private static final int coins[] = {1,3,4};
	private static int total =100;

	public static void main(String[] args) {
		timer t = new timer();
		t.startTimer();
		System.out.println("Greedy number of coins: "+greedy(total).size());
		System.out.println("Greedy Time: "+t.getElapsedTime());
		t.startTimer();

	}
	
	private static ArrayList<Integer> greedy(int total){
		ArrayList<Integer> coinsList = new ArrayList<Integer>();
		
		while(total>0){
			int coin = findMaxCoin(total);
			if(coin== -1){
				System.out.println("Cannot make exact combination");
				return null;
			}else{
				coinsList.add(coin);
				total -= coin;
			}
		}
		return coinsList;
	}

	private static int findMaxCoin(int total) {
		for(int i=coins.length-1;i>=0;i--){
			if(coins[i]<=total)
				return coins[i];
		}
		return -1;
	}
	
//	private static ArrayList<Integer> dynamic(int total){
//		
//	}

}
