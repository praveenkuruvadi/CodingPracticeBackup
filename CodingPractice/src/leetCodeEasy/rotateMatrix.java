package leetCodeEasy;

public class rotateMatrix {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[] temp = new int[length];
        int tempInt=0;
        
        for(int i=0;i<matrix.length/2;i++){
            temp = matrix[i];
            matrix[i]=matrix[matrix.length-1-i];
            matrix[matrix.length-1-i]=temp;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j =i;j<matrix.length;j++){
                tempInt = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tempInt;
            } 
        }
        
    }

}
