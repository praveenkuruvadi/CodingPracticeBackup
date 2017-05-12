package leetCodeEasy;

import java.util.HashSet;

public class sudokuValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hashrow,hashcolumn,hashbox;
        for(int i=0;i<board.length;i++){
            hashcolumn= new HashSet<Character>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(hashcolumn.contains(board[i][j]))
                        return false;
                    else
                        hashcolumn.add(board[i][j]);
                }
            }
        }
        
        for(int j=0;j<board.length;j++){
            hashrow= new HashSet<Character>();
            for(int i=0;i<board.length;i++){
                if(board[i][j] != '.'){
                    if(hashrow.contains(board[i][j]))
                        return false;
                    else
                        hashrow.add(board[i][j]);
                }
            }
        }
        
        for(int i=0;i<board.length;i+=3){
            for(int j=0;j<board[0].length;j+=3){
                hashbox=new HashSet<Character>();
                for(int k=i;k<=i+2;k++){
                    for(int l=j;l<=j+2;l++){
                        if(board[k][l] != '.'){
                            if(hashbox.contains(board[k][l]))
                                return false;
                            else
                                hashbox.add(board[k][l]);
                        }
                    }
                }
            }
        }
        

        return true;
    }

}
