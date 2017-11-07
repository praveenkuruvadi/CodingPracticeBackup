package HackerRank;

public class numberOfWaysToDestination {
	  static int numOfPathsToDest(int n) {
		    // your code goes here
		    int[][] grid = new int[n][n];
		    for(int i=0;i<n;i++){
		      for(int j=0;j<n;j++){
		        if(j>i)
		          grid[i][j]=-1;
		        else
		          grid[i][j]=0;
		      }
		    }
		    
		    return numberOfWays(grid,0,0);
		  }
		  
		  private static int numberOfWays(int[][] grid,int i,int j){
		    if(isSafe(grid,i,j)){
		      if(i==grid.length-1 && j==grid[0].length-1)
		        return 1;
		      int[] row ={0,1};
		      int[] col ={1,0};
		      int count =0;
		      for(int k=0;k<row.length;k++){
		         count+=numberOfWays(grid,i+row[k],j+col[k]);
		      }
		      return count;
		    }else
		      return 0;
		    
		  }
		  
		  private static boolean isSafe(int[][] grid,int i,int j){
		    if(i>grid.length-1||j>grid[0].length-1||i<0||j<0||grid[i][j]!=0)
		      return false;
		    return true;
		  }

		  public static void main(String[] args) {
		      System.out.println(numOfPathsToDest(4));
		  }

}
