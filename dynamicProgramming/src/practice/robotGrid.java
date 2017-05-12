package practice;

import java.util.Random;

public class robotGrid {
	
	private static final int r = 3;
	private static final int d = 3;
	private static int offLimitCells=2;
	
	public static void main(String[] args) {
		
		int[][] grid = new int[r][d];
		int[][] solution = new int[r][d];
		int[][] solutionDynamic = new int[r][d];
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				grid[i][j]=0;
				solution[i][j]=0;
				solutionDynamic[i][j]=0;
			}
				
		}
		Random rand = new Random();
		int randi=0,randj=0;
		while(offLimitCells>0){
			randi= rand.nextInt(r);
			randj=rand.nextInt(d);
			if(grid[randi][randj]==0 && 
					!(randi==0 && randj==0) && 
					!(randi==r-1 && randj == d-1)){
				grid[randi][randj]=-1;
				offLimitCells--;
			}
		}
		printGrid(grid);
		String test ="";
		String out = test+"x";
		System.out.println(out);
		solution[r-1][d-1]=1;
		System.out.println(findPath(grid,solution,r-1,d-1));
		int val =DynamicNumberOfWays(grid,solutionDynamic,r-1,d-1);
		System.out.println("Number of Ways:"+val);
		
	}
	
	private static boolean findPath(int[][]grid, int[][]solution,int i,int j){
		if(i==0 && j==0){
			System.out.println("Reached");
			solution[i][j]=1;
			return true;
		}
		else if(isSafe(grid,i,j)){
			solution[i][j]=1;
			if(findPath(grid,solution,i-1,j))
				return true;
			if(findPath(grid,solution,i,j-1))
				return true;
			return false;
		}else
			return false;
		
	}
	private static int DynamicNumberOfWays(int[][] grid,int[][] solution,int i,int j){
		if(i==0 && j==0){
			System.out.println("Reached:"+solution[i+1][j]+" :"+solution[i][j+1]);
			solution[i][j]=solution[i+1][j]+solution[i][j+1];
			return 0;
		}
		else if(i<0||j<0)
			return 0;
		else if(solution[i][j] >0)
			return solution[i][j];
		else{
			solution[i][j]= paths(grid, i, j)+DynamicNumberOfWays(grid,solution,i-1,j)
				+DynamicNumberOfWays(grid,solution,i,j-1);
			return solution[i][j];
			}
	}
	private static int paths(int[][] grid,int i,int j){
		if(i>=1 && i<grid.length && j>=1 && j< grid[0].length){
			if(grid[i-1][j]!=-1 && grid[i][j-1]!=-1)
				return 2;
			else if(grid[i-1][j]!=-1||grid[i][j-1]!=-1)
				return 1;
		}
		return 0;
	}
	
	private static Boolean isSafe(int[][] grid,int i,int j){
		if(i>=0 && i<grid.length && j>=0 && j< grid[0].length && grid[i][j]!=-1)
			return true;
		else 
			return false;
	}
	
	
	
	private static void printGrid(int[][] grid){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");	
		}
	}
	
	
	

}
