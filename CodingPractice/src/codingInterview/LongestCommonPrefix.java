package codingInterview;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
		String[] input2 = {"ABCDEFG", "ABCEFG" , "ABCEFA"};
		System.out.println(getLongestCommonPrefix(input2,0,input2.length-1));

	}

	private static String getLongestCommonPrefix(String[] input, int left, int right) {
		if(left == right)
			return input[left];
		else{
			int mid = (left+right)/2;
			String leftComm = getLongestCommonPrefix(input,left,mid);
			String rightComm = getLongestCommonPrefix(input,mid+1,right);
			return commonCompute(leftComm,rightComm);
		}
	}

	private static String commonCompute(String leftComm, String rightComm) {
		StringBuilder sb = new StringBuilder();
		int i=0;
		while(i<leftComm.length() && i<rightComm.length()){
			if(leftComm.charAt(i) == rightComm.charAt(i))
				sb.append(leftComm.charAt(i));
			else
				break;
			i++;
		}
		return sb.toString();
	}

}
