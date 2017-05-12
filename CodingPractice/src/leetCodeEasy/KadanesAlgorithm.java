package leetCodeEasy;

public class KadanesAlgorithm {
	public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int maxSoFar =0;
        int maxEndHere =0;
        for(int i=0;i<prices.length-1;i++){
            maxEndHere = Math.max(0,maxEndHere+prices[i+1]-prices[i]);
            maxSoFar = Math.max(maxSoFar,maxEndHere);
        }
        return maxSoFar;
    }

}
