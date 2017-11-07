package RecursionAndDynamic;

import java.util.HashSet;

public class allValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		HashSet<String> valid = new HashSet<String>();
		allValidCombinations(n,n,valid,"");
		for(String s:valid)
			System.out.println(s);

	}

	private static void allValidCombinations(int left, int right, HashSet<String> valid, String current) {
		// TODO Auto-generated method stub
		if(left<0||right<left)
			return;
		if(left ==0 && right ==0){
			valid.add(current);
			return;
		}
		if(left>0)
			allValidCombinations(left-1,right,valid,current+"(");
		if(left<right)
			allValidCombinations(left,right-1,valid,current+")");
		
	}

}
