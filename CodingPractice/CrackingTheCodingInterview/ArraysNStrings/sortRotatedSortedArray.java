package ArraysNStrings;

public class sortRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 3, 4, 5, 1, 2 };
		sortArray(input);
		for(int i:input)
			System.out.print(i+" ");
		
	}

	private static void sortArray(int[] input) {
		// TODO Auto-generated method stub
		for(int i=0;i<input.length-1;i++){
			if(input[i]>input[i+1]){
				reverseArray(input,0,i);
				reverseArray(input,i+1,input.length-1);
				break;
			}
		}
		reverseArray(input,0,input.length-1);
	}

	private static void reverseArray(int[] input, int start, int end) {
		// TODO Auto-generated method stub
		if(start==end || start>end)
			return;
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
		reverseArray(input,start+1,end-1);
	}

}
