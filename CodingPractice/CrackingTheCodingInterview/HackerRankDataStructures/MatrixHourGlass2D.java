package HackerRankDataStructures;

import java.util.Scanner;

public class MatrixHourGlass2D {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int matrix[][] = new int[6][6];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(maxHourGlass(matrix));
    }
    
    private static int maxHourGlass(int[][] matrix){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=matrix.length-3;i++){
            for(int j=0;j<=matrix[0].length-3;j++){
                max = Math.max(getHourGlassSum(matrix,i,j),max);
            }
        }
        return max;
    }
    
    private static int getHourGlassSum(int[][] matrix, int i,int j){
        int sum =0;
        for(int k=i;k<i+3;k++){
            for(int l=j;l<j+3;l++){
                if(!((k==i+1 && l==j)||(k==i+1 && l==j+2)))
                    sum+=matrix[k][l];
            }
        }
        return sum;
    }

}
