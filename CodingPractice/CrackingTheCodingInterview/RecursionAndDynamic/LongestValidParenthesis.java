package RecursionAndDynamic;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "((())";
		
		System.out.println(longestValidParen(input));

	}

	private static int longestValidParen(String input) {
		// TODO Auto-generated method stub
		int[] holdArr = new int[input.length()];
		Arrays.fill(holdArr, 0);
		int max =0;
		for(int i = 1;i<input.length();i++){
			char ch = input.charAt(i);
			if(ch == ')')
				if(input.charAt(i-1) == '('){
					holdArr[i] = holdArr[i-1]+2;
					max = Math.max(holdArr[i], max);
				}
					
				else if(i>=2 && input.charAt(i-holdArr[i-1]-1)=='('){
					holdArr[i] = holdArr[i-1] + holdArr[i-holdArr[i-1]-2]+2;
					max = Math.max(holdArr[i], max);
				}
		}
		return max;
	}
	

}
