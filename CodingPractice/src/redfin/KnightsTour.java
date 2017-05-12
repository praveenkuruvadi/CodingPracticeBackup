package redfin;

public class KnightsTour {
	
	private static int[][] matrix;
	private static int n=8;
	
	public static void main(String[] args){
		matrix= new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=-1;
			}
		}
		matrix[0][0]=0;
		int[] xmove = {1,2,2,1,-1,-2,-2,-1};
		int[] ymove = {2,1,-1,-2,-2,-1,1,2};
		int count=1;
		if(knightTour(0,0,xmove,ymove,1))
			printBoard();
		else
			System.out.println("No solution");
	}
	private static boolean knightTour(int x,int y,int[] xmove, int[] ymove, int count){
		if(count== n*n)
			return true;
		int next_x,next_y;
		for(int i=0;i<8;i++){
			next_x=x+xmove[i];
			next_y=y+ymove[i];
			if(isSafe(next_x,next_y)){
				matrix[next_x][next_y]= count;
				if(knightTour(next_x,next_y,xmove,ymove,count+1))
					return true;
				else
					matrix[next_x][next_y]=-1;
			}
		}
		return false;
		
	}
	
	private static boolean isSafe(int x,int y){
		return(x>=0 && y>=0 && x<n && y<n && matrix[x][y]==-1);
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
