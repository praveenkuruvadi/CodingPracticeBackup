package otherProblems;
///Resolve Issue
public class longestPalindrome {
	private static String input ="axbawbaseksqke";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = recursiveLongestPalindrome(input,0,input.length()-1);
		System.out.println(len);
		System.out.println("Dynamic method:"+dynamicLongestPalindrome(input));
		//System.out.println(dynamicLongestPalindrome(input));
	}
	
	
	private static int recursiveLongestPalindrome(String input, int start,int end) {
		if(start == end)
			return 1;
		else if(end-start==1 && input.charAt(start)==input.charAt(end))
			return 2;
		else if(input.charAt(start)==input.charAt(end))
			return 2+recursiveLongestPalindrome(input,start+1,end-1);
		else 
			return Math.max(recursiveLongestPalindrome(input,start+1,end), 
					recursiveLongestPalindrome(input,start,end-1));
	}
	
	private static int dynamicLongestPalindrome(String input){
		//TODO Traversal
		int[][] tempData= new int[input.length()][input.length()];
		for(int i=0;i<input.length();i++)
			tempData[i][i]=1;
		int j=0;
		for(int len=2;len<=input.length();len++){
			for(int i=0;i<input.length()-len+1;i++){
				j=i+len-1;
				if(input.charAt(i)==input.charAt(j)&& len==2)
					tempData[i][j]=2;
				else if(input.charAt(i)==input.charAt(j))
					tempData[i][j]= 2+tempData[i+1][j-1];
				else
					tempData[i][j]= Math.max(tempData[i+1][j], tempData[i][j-1]);
			}
		}
		//return tempData[0][input.length()-1];
		int max =0;
		for(int i=1;i<input.length();i++)
			max= Math.max(max, tempData[0][i-1]*tempData[i][input.length()-1]);
		return max;
		
	}
	
	private static String dynamicLongestPalindromeString(String input){
		boolean matrix[][] = new boolean[input.length()][input.length()];
		int start =0,len=1;
		for(int i=0;i<input.length();i++)
			matrix[i][i]=Boolean.TRUE;
		for(int i=0;i<input.length()-1;i++){
			if(input.charAt(i)==input.charAt(i+1)){
				start=i;
				matrix[i][i+1]=Boolean.TRUE;
				len=2;
			}
				
		}
		for(int length=3;length<input.length();length++){
			for(int i=0;i<input.length()-length;i++){
				int j= i+length-1;
				if(matrix[i-1][j-1] && input.charAt(i)==input.charAt(j)){
					matrix[i][j]=Boolean.TRUE;
					if(length>len){
						start=i;
						len=length;
					}
				}
					
			}
		}
		StringBuilder sb = new StringBuilder(input);
		
		return sb.substring(start, start+len-1);
	}
 
}
