package redfin;

public class NQueens {
	
	private static int[][] matrix;
	private static int n=8;
	private static int queens=8;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matrix = new int[8][8];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				matrix[i][j]=0;
		}
		if(placeQueens(0))
			printBoard();
		else
			System.out.println("No solution");
	}
	
	private static boolean placeQueens(int col){
		if(col==queens)
			return true;
		for(int i=0;i<n;i++){
			if(isSafe(i,col)){
				matrix[i][col]=1;
				if(placeQueens(col+1))
					return true;
				else
					matrix[i][col]=0;
			}
		}
		return false;
	}
	private static boolean isSafe(int x,int y){
		for(int i=0;i<n;i++){
			if(matrix[x][i]==1)
				return false;
		}
		for(int i=x, j=y;i>=0 && j>=0;i--,j--){
			if(matrix[i][j]==1)
				return false;
		}
		for(int i=x, j=y;i<n && j>=0;i++,j--){
			if(matrix[i][j]==1)
				return false;
		}
		return true;
	}
	private static void printBoard(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
