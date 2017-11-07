package BlackRock;

import java.util.Arrays;

public class sortStringDescending {
	public static void main(String[] args){
		String input = "geeksforgeeks";
		System.out.println(sortDescending(input));
	}

	private static String sortDescending(String input) {
		// TODO Auto-generated method stub
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		char[] charArr = input.toCharArray();
		for(int i=0;i<charArr.length;i++){
			arr[(int)charArr[i]-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1;i>=0;i--){
			while(arr[i]>0){
				sb.append((char)('a'+i));
				arr[i]--;
			}
		}
		return sb.toString();
	}

}