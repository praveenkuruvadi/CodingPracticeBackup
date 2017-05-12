package matrixMulti;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class memoized {

	private static volatile int scalarCount=0;
	private static volatile int recursiveCount=0;
	private static int lookUpTable[][];
	
	public static void main(String[] args) {
		int matrixDimensions[] = {5,6,5,5,8,10,9,11,7};
		writeToFile("N,MinMultiplications,TimeTaken,Scalar,RecursiveCalls");
		for(int n=5;n<=matrixDimensions.length;n++){
			int lookUpTable[][] = new int[n+1][n+1];
			for(int i=0;i<=n;i++){
				for(int j=i;j<=n;j++){
					lookUpTable[i][j]= Integer.MAX_VALUE;
				}
			}
			System.out.println("Results for N: "+n);
			long start = System.nanoTime();
			int minCount = memoization(matrixDimensions, lookUpTable, 1, n-1);
			System.out.println("Memoized: Min Multiplications: "+minCount);
			long end = System.nanoTime();
			System.out.println("Memoized: Time Taken: "+(end-start)/1000+"ms");
			System.out.println("Memoized: Scalar multiplications: "+scalarCount);
			System.out.println("Memoized: Recursive calls: "+recursiveCount);
			writeToFile(n+","+minCount+","+(end-start)/1000+"ms"+","+scalarCount+","+recursiveCount);
			System.out.println("-------------------");
			System.out.println();
		}

	}

	private static int memoization(int[] arr, int[][] lookUpTable, int i, int j) {
		///Increase recursive counter by 1 for each call of this method
		recursiveCount++;
		if(lookUpTable[i][j]<Integer.MAX_VALUE)
			return lookUpTable[i][j];
		else if(i==j)
			lookUpTable[i][j]=0;
		else{
			lookUpTable[i][j]= Integer.MAX_VALUE;
			for(int k=i;k<=j-1;k++){
				///Increase scalar counter by 1 for each primitive operation done by the above statement
				scalarCount++;
				int value = memoization(arr,lookUpTable,i,k)+memoization(arr,lookUpTable,k+1,j)
							+(arr[i-1]*arr[k]*arr[j]);
				if(value<lookUpTable[i][j]){
					lookUpTable[i][j]=value;
				}
					
			}
		}
		return lookUpTable[i][j];
	}
	
	private static void writeToFile(String write) {
		Writer writer;
		try {
			FileOutputStream FoutStream = new FileOutputStream(
					"memoizedOutput.txt", true);
			try {
				writer = new BufferedWriter(
						new OutputStreamWriter(FoutStream, "UTF-8"));
					
				writer.append(write);
				writer.append("\n");

				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				FoutStream.close();
			}
		} catch (Exception e) {
		}
	}

}
