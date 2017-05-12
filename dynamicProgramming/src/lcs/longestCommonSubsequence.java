package lcs;
import java.util.ArrayList;

import timerClass.timer;

public class longestCommonSubsequence {
	private static final String in1 = "ABCDGH";
	private static final String in2 = "AEDFHRG";
	private static ArrayList<Character> subsequence;
	
	public static void main(String[] args) {
		subsequence = new ArrayList<Character>();
		timer t = new timer();
		t.startTimer();
		System.out.println("Recursive LCS Length: "+recursive(in1.length()-1,in2.length()-1)); 
		System.out.println("Recursive time: "+t.getElapsedTime());
		t.startTimer();
		System.out.println("Dynamic LCS length: "+dynamic());
		System.out.println("Dynamic time: "+t.getElapsedTime());
	}
	
	private static int recursive(int i,int j){
		if(i<0 || j<0)
			return 0;
		else if(in1.charAt(i)== in2.charAt(j))
			return 1+recursive(i-1,j-1);
		else
			return Math.max(recursive(i-1,j),recursive(i,j-1));
	}
	
	private static int dynamic(){
		int lookUp[][] = new int[in1.length()+1][in2.length()+1];
		
		for(int i = 0;i<=in1.length();i++){
			for(int j=0;j<=in2.length();j++){
				if(i==0 || j==0)
					lookUp[i][j]=0;
				else if(in1.charAt(i-1)==in2.charAt(j-1))
					lookUp[i][j]= lookUp[i-1][j-1]+1;
				else
					lookUp[i][j] = Math.max(lookUp[i-1][j], lookUp[i][j-1]);
			}
		}
		return lookUp[in1.length()][in2.length()];
	}
	
	

}
