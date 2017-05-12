package codingInterview;

public class stringCompression {

	public static void main(String[] args) {
		String toCompress = "aabcccccaaa";
		StringBuilder sb = new StringBuilder();
		int count =0;
		char[] arr = toCompress.toCharArray();
		char currentChar = 0;
		for(int i=0;i<arr.length;i++){
			if(count==0){
				currentChar=arr[i];
				count++;
			}else if(currentChar!=arr[i] || i==arr.length-1){
				sb.append(currentChar);
				sb.append(count);
				i--;
				count=0;
			}else
				count++;
		}
		System.out.println(sb.toString());
	}

}
