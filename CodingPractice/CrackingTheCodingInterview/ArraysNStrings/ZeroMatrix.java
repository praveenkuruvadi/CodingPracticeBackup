package ArraysNStrings;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputMatrix[][] =
	        {
	            {1, 2, 3, 4},
	            {5, 6, 7, 0},
	            {9, 0, 0, 12},
	            {13, 14, 15, 16}
	        };
		
		printMatrix(inputMatrix);
		zeroMatrix(inputMatrix);
		printMatrix(inputMatrix);
	}
	
	private static void zeroMatrix(int[][] inputMatrix) {
		// TODO Auto-generated method stub
		int rows[] = new int[inputMatrix.length];
		int col[] = new int[inputMatrix[0].length];
		Arrays.fill(rows, 0);
		Arrays.fill(col, 0);
		
		for(int i=0;i<inputMatrix.length;i++){
			for(int j=0;j<inputMatrix[0].length;j++){
				if(inputMatrix[i][j]==0){
					rows[i]++;col[j]++;
				}
			}
		}
		for(int i=0;i<rows.length;i++){
			if(rows[i]>0){
				for(int j=0;j<inputMatrix.length;j++)
					inputMatrix[i][j]=0;
			}
		}
		for(int i=0;i<col.length;i++){
			if(col[i]>0){
				for(int j=0;j<inputMatrix[0].length;j++)
					inputMatrix[j][i]=0;
			}
		}
	}

	private static void printMatrix(int[][] inputMatrix) {
		// TODO Auto-generated method stub
		for(int i=0;i<inputMatrix.length;i++){
			for(int j=0;j<inputMatrix[0].length;j++){
				System.out.print(inputMatrix[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

}
