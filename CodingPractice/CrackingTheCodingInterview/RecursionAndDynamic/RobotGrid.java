package RecursionAndDynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

class Point{
	int row;
	int col;
	public Point(int row,int col){
		this.row = row;
		this.col = col;
	}
	
	public String getPoint(){
		return "<"+row+","+col+">";
	}
}

public class RobotGrid {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 4;
	    int c = 4;
		int offLimitCells=3;
		int[][] grid = new int[r][c];
		HashMap<Point,Boolean> lookUp = new HashMap<Point,Boolean>();
		int[][] lookUpWays = new int[r][c];
		initializeGrid(grid,lookUpWays,r,c,offLimitCells);
		printGrid(grid);
		ArrayList<Point> path = new ArrayList<Point>();
		System.out.println(findPath(grid,r-1,c-1,path));
		for(Point p:path)
			System.out.println(p.getPoint());
		path = new ArrayList<Point>();
		System.out.println(findPathDynamic(grid,lookUp,r-1,c-1,path));
		for(Point p:path)
			System.out.println(p.getPoint());
		System.out.println("Number of Ways Recursive:"+numberOfWaysRecursive(grid,r-1,c-1));
		System.out.println("Number of Ways Dynamic:"+numberOfWaysDynamic(grid,lookUpWays,r-1,c-1));
		
	}

	private static int numberOfWaysDynamic(int[][] grid, int[][] lookUpWays, int row, int col) {
		// TODO Auto-generated method stub
		if(row==0&&col==0)
			return 1;
		else if(!isSafe(grid,row,col))
			return 0;
		else if(lookUpWays[row][col]>0)
			return lookUpWays[row][col];
		else{
			lookUpWays[row][col]=numberOfWaysRecursive(grid,row-1,col)+numberOfWaysRecursive(grid,row,col-1);
			return lookUpWays[row][col];
		}
	}

	private static int numberOfWaysRecursive(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		if(row==0&&col==0)
			return 1;
		else if(!isSafe(grid,row,col))
			return 0;
		else
			return numberOfWaysRecursive(grid,row-1,col)+numberOfWaysRecursive(grid,row,col-1);
	}

	private static boolean findPathDynamic(int[][] grid, HashMap<Point, Boolean> lookUp, int row, int col,
			ArrayList<Point> path) {
		// TODO Auto-generated method stub
		if(!isSafe(grid, row, col))
			return false;
		Point p = new Point(row,col);
		if(lookUp.containsKey(p))
			return lookUp.get(p);
		if(row == 0 && col == 0){
			path.add(new Point(row,col));
			return true;
		}else if((findPath(grid,row-1,col,path)||findPath(grid,row,col-1,path))){
			lookUp.put(p, true);
			path.add(p);
			return true;
		}
		return false;
	}

	private static boolean findPath(int[][] grid, int row, int col, ArrayList<Point> path) {
		// TODO Auto-generated method stub
		if(row == 0 && col == 0){
			path.add(new Point(row,col));
			return true;
		}else if(isSafe(grid, row, col) && (findPath(grid,row-1,col,path)||findPath(grid,row,col-1,path))){
			path.add(new Point(row,col));
			return true;
		}
		return false;
	}

	private static boolean isSafe(int[][] grid, int row, int col) {
		if(row>=0 && row<grid.length && col>=0 && col< grid[0].length && grid[row][col]!=-1)
			return true;
		else 
			return false;
	}

	private static void printGrid(int[][] grid) {
		// TODO Auto-generated method stub
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");	
		}
	}

	private static void initializeGrid(int[][] grid, int[][] lookUpWays, int r, int c, int offLimitCells) {
		// TODO Auto-generated method stub
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				grid[i][j]=0;
				lookUpWays[i][j]=0;
			}
		}
		Random rand = new Random();
		int randi=0,randj=0;
		while(offLimitCells>0){
			randi= rand.nextInt(r);
			randj=rand.nextInt(c);
			if(grid[randi][randj]==0 && 
					!(randi==0 && randj==0) && 
					!(randi==r-1 && randj == c-1)){
				grid[randi][randj]=-1;
				offLimitCells--;
			}
		}
	}

}
