package HackerRank;

import java.util.Scanner;

public class maxRegion {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int matrix[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++)
                matrix[i][j] = in.nextInt();
        }
        System.out.println(maxRegion(matrix));
    }
    
    private static int maxRegion(int[][] matrix){
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1)
                    max = Math.max(max,dfsSearch(matrix,i,j));
            }
        }
        return max;
    }
    
    private static int dfsSearch(int[][] matrix,int i,int j){
        int row[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int col[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        if(isSafe(matrix,i,j)){
            matrix[i][j] = 2;
            int count =1;
            for(int k = 0;k<row.length;k++){
                count+=dfsSearch(matrix,i+row[k],j+col[k]);
            }
            return count;
        }else
            return 0;
    }
    
    
    private static boolean isSafe(int[][] matrix, int x,int y){
        if(x<0||y<0||x>matrix.length-1||y>matrix[0].length-1||matrix[x][y]!=1)
            return false;
        return true;
    }
}
