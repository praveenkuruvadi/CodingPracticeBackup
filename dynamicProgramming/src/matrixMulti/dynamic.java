package matrixMulti;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

public class dynamic {

	private static volatile int scalarCount=0;
	public static void main(String[] args) {
		int matrixDimensions[] = {5,6,5,5,8,10,9,11,7};
		writeToFile("N,MinMultiplications,TimeTaken,Scalar");
		for(int i=5;i<=matrixDimensions.length;i++){
			System.out.println("Results for N: "+i);
			long start = System.nanoTime();
			int minCount=dynamic(Arrays.copyOfRange(matrixDimensions, 0, i));
			System.out.println("Dynamic: Min Multiplications: "+minCount);
			long end = System.nanoTime();
			System.out.println("Dynamic: Time Taken: "+(end-start)/1000+"ms");
			System.out.println("Dynamic: Scalar multiplications: "+scalarCount);
			writeToFile(i+","+minCount+","+(end-start)/1000+"ms"+","+scalarCount);
			System.out.println("-------------------");
			System.out.println();
		}
		
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
					///Increase scalar counter by 1 for each primitive operation done by the above statement
					scalarCount++;
					int value = dynamicLookUp[i][k]+dynamicLookUp[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(value<dynamicLookUp[i][j])
						dynamicLookUp[i][j]=value;
				}
			}
		}
		return dynamicLookUp[1][arr.length-1];
	}
	
	private static void writeToFile(String write) {
		Writer writer;
		try {
			FileOutputStream FoutStream = new FileOutputStream(
					"dynamicOutput.txt", true);
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
