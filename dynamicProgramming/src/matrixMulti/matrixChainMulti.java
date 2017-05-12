package matrixMulti;

import timerClass.timer;
public class matrixChainMulti {

	public static void main(String[] args) {
		
		timer t = new timer();
		int matrixDimensions[] = {30,35,15,5,10,20,25};
		t.startTimer();
		System.out.println("Recursive: Min Multiplications: "+recursive(matrixDimensions,1,matrixDimensions.length-1));
		System.out.println("Recursive: Time Taken: "+t.getElapsedTime());
		t.startTimer();
		System.out.println("Memoization: Min Multiplications: "+memoization(matrixDimensions));
		System.out.println("Memoization: Time Taken: "+t.getElapsedTime());
		t.startTimer();
		System.out.println("Dynamic: Min Multiplications: "+dynamic(matrixDimensions));
		System.out.println("Dynamic: Time Taken: "+t.getElapsedTime());

	}
	
	private static int recursive(int[] arr, int i, int j){
		if(i==j)
			return 0;
		int minMulti = Integer.MAX_VALUE;
		for(int k = i;k<=j-1;k++){
			int value = recursive(arr,i, k)+recursive(arr,k+1, j)+(arr[i-1]*arr[k]*arr[j]);
			if(value<minMulti)
				minMulti=value;
		}
		return minMulti;
	}
	
	private static int memoization(int[] arr){
		int lookUpTable[][] = new int[arr.length+1][arr.length+1];
		for(int i=0;i<=arr.length;i++){
			for(int j=i;j<=arr.length;j++){
				lookUpTable[i][j]= Integer.MAX_VALUE;
			}
		}
		return helperMemoization(arr, lookUpTable, 1, arr.length-1);
	}

	private static int helperMemoization(int[] arr, int[][] lookUpTable, int i, int j) {
		if(lookUpTable[i][j]<Integer.MAX_VALUE)
			return lookUpTable[i][j];
		else if(i==j)
			lookUpTable[i][j]=0;
		else{
			lookUpTable[i][j]= Integer.MAX_VALUE;
			for(int k=i;k<=j-1;k++){
				int value = helperMemoization(arr,lookUpTable,i,k)+helperMemoization(arr,lookUpTable,k+1,j)
							+(arr[i-1]*arr[k]*arr[j]);
				if(value<lookUpTable[i][j]){
					lookUpTable[i][j]=value;
				}
					
			}
		}
		return lookUpTable[i][j];
	}
	
	private static int dynamic(int[] arr){
		int dynamicLookUp[][] = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++)
			dynamicLookUp[i][i]=0;
		for(int l=2;l<arr.length;l++){
			for(int i=1;i<arr.length-l+1;i++){
				int j= i+l-1;
				dynamicLookUp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++){
					int value = dynamicLookUp[i][k]+dynamicLookUp[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(value<dynamicLookUp[i][j])
						dynamicLookUp[i][j]=value;
				}
			}
		}
		return dynamicLookUp[1][arr.length-1];
	}
}
