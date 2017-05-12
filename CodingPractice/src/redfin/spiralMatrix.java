package redfin;

public class spiralMatrix {

	public static void main(String[] args) {
		int matrix[][] = {{1,  2,  3,  4},
		        {5,6,7,8},
		        {9,10,11,12},
		        {13,14,15,16}
		};
		int n =3;
		//printSpiral(matrix);
		makeSpiral(n);
		
		
	}
	
	private static void makeSpiral(int n) {
		int count=1,maxRow=n-1,maxCol=n-1,minRow=0,minCol=0;
		int matrix[][] = new int[n][n];
		while(count<=n*n){
			for(int i=minCol;i<=maxCol;i++)
				matrix[minRow][i]=count++;
			for(int i=minRow+1;i<=maxRow;i++)
				matrix[i][maxCol]=count++;
			for(int i=maxCol-1;i>=minCol;i--)
				matrix[maxRow][i]=count++;
			for(int i=maxRow-1;i>minRow;i--)
				matrix[i][minCol]=count++;
			
			minCol++;minRow++;
			maxCol--;maxRow--;
		}
		
		for(int i=0;i<n;i++){
			System.out.println("");
			for(int j=0;j<n;j++)
				System.out.print(matrix[i][j]+" ");
		}
		
		
		
	}

	private static void printSpiral(int[][] matrix){
		int rows = matrix.length-1,columns= matrix[0].length-1;
		int l=0,k=0;
		while(k<=rows && l<=columns){
			for(int i=l;i<=columns;i++)
				System.out.print(matrix[k][i]+",");
			k++;
			for(int j=k;j<=rows;j++)
				System.out.print(matrix[j][columns]+",");
			columns--;
			if(k<rows){
				for(int i=columns;i>=l;i--)
					System.out.print(matrix[rows][i]+",");
				rows--;
			}
			if(l<columns){
				for(int j=rows;j>=k;j--)
					System.out.print(matrix[j][l]+",");
				l++;
			}
		}
	}

}
