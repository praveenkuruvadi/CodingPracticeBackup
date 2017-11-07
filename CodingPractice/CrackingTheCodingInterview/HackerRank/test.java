package HackerRank;

import java.util.Arrays;
import java.util.HashSet;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	  static boolean sudokuSolve(String[][] board) {
		    // your code goes here
		    HashSet<Integer> set = new HashSet<Integer>();
		    for(int i=0;i<board.length;i++){
		      set = new HashSet<Integer>();
		      for(int j=0;j<board[0].length;j++){
		        if(board[i][j]!="."){
		          int num = Integer.parseInt(board[i][j]);
		        if(set.contains(num)||num>9||num<1)
		          return false;
		        else
		          set.add(num);
		        }
		      }
		    }
		   set = new HashSet<Integer>();
		   for(int i=0;i<board[0].length;i++){
		      set = new HashSet<Integer>();
		      for(int j=0;j<board.length;j++){
		        if(board[j][i]!="."){
		          int num = Integer.parseInt(board[j][i]);
		        if(set.contains(num)||num>9||num<1)
		          return false;
		        else
		          set.add(num);
		        }
		      }
		    }
		    
		    for(int i=0;i<board.length;i+=3){
		      set = new HashSet<Integer>();
		      for(int j=i;j<i+3;j++){
		        for(int k=i;k<i+3;k++){
		          if(board[j][k] != "."){
		            int num = Integer.parseInt(board[j][k]);
		            if(set.contains(num)||num>9||num<1)
		              return false;
		            else
		              set.add(num);
		          }
		        }
		      }
		    }
		    return true;
		  }

}
