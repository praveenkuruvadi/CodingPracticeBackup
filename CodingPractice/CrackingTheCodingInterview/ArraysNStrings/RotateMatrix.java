package ArraysNStrings;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputMatrix[][] =
	        {
	            {1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {9, 10, 11, 12},
	            {13, 14, 15, 16}
	        };
		
		printMatrix(inputMatrix);
		rotateMatrix(inputMatrix);

	}

	private static void rotateMatrix(int[][] inputMatrix) {
		// TODO Auto-generated method stub
		int temp=0;
		for(int i =0;i<inputMatrix.length/2;i++){
			for(int j=i;j<=inputMatrix.length-i-1;j++){
				System.out.println(inputMatrix[i][j]);
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
	}

}
