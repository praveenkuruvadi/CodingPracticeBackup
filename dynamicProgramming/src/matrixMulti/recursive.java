package matrixMulti;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class recursive {

	private static volatile int scalarCount=0;
	private static volatile int recursiveCount=0;
	public static void main(String[] args) {
		int matrixDimensions[] = {5,6,5,5,8,10,9,11,7};
		writeToFile("N,MinMultiplications,TimeTaken,Scalar,RecursiveCalls");
		for(int i=5;i<=matrixDimensions.length;i++){
			System.out.println("Results for N: "+i);
			long start = System.nanoTime();
			int minCount=recursive(matrixDimensions,1,i-1);
			System.out.println("Recursive: Min Multiplications: "+minCount);
			long end = System.nanoTime();
			System.out.println("Recursive: Time Taken: "+(end-start)/1000+"ms");
			System.out.println("Recursive: Scalar multiplications: "+scalarCount);
			System.out.println("Recursive: Recursive calls: "+recursiveCount);
			writeToFile(i+","+minCount+","+(end-start)/1000+"ms"+","+scalarCount+","+recursiveCount);
			System.out.println("-------------------");
			System.out.println();
		}
		

	}
	
	private static int recursive(int[] arr, int i, int j){
		///Increase recursive counter by 1 for each call of this method
		recursiveCount++;
		if(i==j)
			return 0;
		int minMulti = Integer.MAX_VALUE;
		for(int k = i;k<=j-1;k++){
			int value = recursive(arr,i, k)+recursive(arr,k+1, j)+(arr[i-1]*arr[k]*arr[j]);
			///Increase scalar counter by 1 for each primitive operation done by the above statement
			scalarCount++;
			if(value<minMulti)
				minMulti=value;
		}
		return minMulti;
	}
	
	private static void writeToFile(String write) {
		Writer writer;
		try {
			FileOutputStream FoutStream = new FileOutputStream(
					"recursiveOutput.txt", true);
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
