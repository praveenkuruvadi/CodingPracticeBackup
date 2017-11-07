package TreesNGraphs;

public class countingIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][]=  new int[][] {{1, 1, 0, 0, 0},
						            {0, 1, 0, 0, 1},
						            {1, 0, 0, 1, 1},
						            {0, 0, 0, 0, 0},
						            {1, 0, 1, 0, 1}
						           };
           
        System.out.println(countNumberOfIslands(input));
	}
	
	

	private static int countNumberOfIslands(int[][] input) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[input.length][input[0].length];
		for(int i=0;i<visited.length;i++){
			for(int j=0;j<visited[0].length;j++)
				visited[i][j]=Boolean.FALSE;
		}
		
		int count =0;
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]==1 && !visited[i][j]){
					dfsFromPoint(i,j,input,visited);
					count++;
				}
			}
		}
		return count;
	}



	private static void dfsFromPoint(int i, int j, int[][] input, boolean[][] visited) {
		// TODO Auto-generated method stub
		int row[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int col[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
		visited[i][j] = Boolean.TRUE;
		for(int k=0;k<row.length;k++){
			if(isSafe(i+row[k],j+col[k],input,visited))
				dfsFromPoint(i+row[k],j+col[k],input,visited);
		}
	}



	private static boolean isSafe(int i, int j, int[][] input, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(i>=0 && j>=0 && i<input.length&& j<input[0].length&& input[i][j]==1 && !visited[i][j])
			return true;
		return false;
	}

}
