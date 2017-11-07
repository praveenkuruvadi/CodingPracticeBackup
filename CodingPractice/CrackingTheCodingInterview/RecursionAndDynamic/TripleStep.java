package RecursionAndDynamic;

import java.util.Arrays;

public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 10;
		int[] lookUp = new int[n+1];
		Arrays.fill(lookUp, 0);
		System.out.println(numberOfWaysRecursive(n));
		System.out.println(numberOfWaysDynamic(n,lookUp));

	}

	private static int numberOfWaysDynamic(int n, int[] lookUp) {
		// TODO Auto-generated method stub
		if(n<0)
			return 0;
		else if(n==0)
			return 1;
		else if(lookUp[n]>0)
			return lookUp[n];
		else{
			lookUp[n] = numberOfWaysDynamic(n-1,lookUp)+ numberOfWaysDynamic(n-2,lookUp)+ numberOfWaysDynamic(n-3,lookUp); 
			return lookUp[n];
		}
	}

	private static int numberOfWaysRecursive(int n) {
		// TODO Auto-generated method stub
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		else
			return numberOfWaysRecursive(n-1) + numberOfWaysRecursive(n-2) + numberOfWaysRecursive(n-3);
	}
	

}
