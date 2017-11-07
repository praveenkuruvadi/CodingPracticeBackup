package SortNSearch;

public class sortedMatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,   3,  5,  7},
						  {10, 11, 16, 20},
						  {23, 30, 34, 50}};
		System.out.println(searchInMatrix(input,10,input.length-1,0));
	}

	private static boolean searchInMatrix(int[][] input, int elem, int row, int col)  {
		// TODO Auto-generated method stub
		if(row>=input.length || col>= input[0].length || row<0 ||col<0)
			return false;
		if(input[row][col] == elem){
			System.out.println("Found at: "+row+","+col);
			return true;
		}
		else if(input[row][col]>elem)
			return searchInMatrix(input,elem,--row,col);
		else
			return searchInMatrix(input,elem,row,++col);
	}

}
