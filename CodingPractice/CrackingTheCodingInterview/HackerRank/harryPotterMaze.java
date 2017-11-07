package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

//Input
//3
//2 3
//*.M
//.X.
//1
//4 11
//.X.X......X
//.X*.X.XXX.X
//.XX.X.XM...
//......XXXX.
//3
//4 11
//.X.X......X
//.X*.X.XXX.X
//.XX.X.XM...
//......XXXX.
//4

class point{
    int x;
    int y;
    public point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class harryPotterMaze {
	private static int count =0;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i=0;i<cases;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] input = new char[n][m];
            for(int j=0;j<n;j++){
                String sIn = in.next();
                for(int k=0;k<m;k++){
                    input[j][k] = sIn.charAt(k);
                }
            }
            int k = in.nextInt();
            System.out.println(checkGuess(input,k));
        }
    }
    
    private static String checkGuess(char[][] input,int k){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                if(input[i][j]=='M'){
                    return searchMaze(input,i,j)&&count==k?"Impressed":"Oops!";
                }
            }
        }
        return "Oops!";
    }

	private static boolean searchMaze(char[][] input, int i, int j) {
        if(input[i][j]=='*')
        	return true;
            
        
        input[i][j] = 'X';
        int row[] = {-1,1,0,0};
        int col[] = {0,0,-1,1};
        ArrayList<point> list = new ArrayList<point>();
        for(int k=0;k<row.length;k++){
            if(isSafe(input,i+row[k],j+col[k]))
                list.add(new point(i+row[k],j+col[k]));
            
        }
        boolean flag = false;
        for(point p:list){
            flag = flag||searchMaze(input,p.x,p.y);
        }
        if(flag && list.size()>1)
            count++;
		return flag;
	}
    
    private static boolean isSafe(char[][] matrix, int x,int y){
        if(x<0||y<0||x>matrix.length-1||y>matrix[0].length-1||matrix[x][y]=='X')
            return false;
        return true;
    }

}
