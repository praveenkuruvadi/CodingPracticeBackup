package practice;

import java.util.Arrays;

public class TripleStep {
	private static final int n=10;
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		int val = recursive(n);
		long end = System.nanoTime();
		System.out.println("Recursive: Number of ways:"+val+" Time: "+(end-start)/1000+"ms");
		int[] lookup = new int[n+1];
		Arrays.fill(lookup, 0);
		start = System.nanoTime();
		val = dynamic(n,lookup);
		end = System.nanoTime();
		System.out.println("Dynamic: Number of ways:"+val+" Time: "+(end-start)/1000+"ms");
	}
	
	private static int recursive(int n){
		if(n<0)
			return 0;
		else if(n==0)
			return 1;
		else 
			return recursive(n-1)+recursive(n-2)+recursive(n-3);
	}
	
	private static int dynamic(int n, int[] lookup){
		if(n<0)
			return 0;
		else if(n==0)
			return 1;
		else if(lookup[n]>0)
			return lookup[n];
		else{
			lookup[n]=dynamic(n-1,lookup)+dynamic(n-2,lookup)+dynamic(n-3,lookup);
			return lookup[n];
		}
			
	}

}
