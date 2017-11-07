package moderate;

public class numberSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {28,34};
		System.out.println(input[0]+" "+input[1]);
		swapNums(input);
		System.out.println("After Swap: "+input[0]+" "+input[1]);
	}

	private static void swapNums(int[] arr) {
		// TODO Auto-generated method stub
		arr[0] = arr[0]+arr[1];
		arr[1] = arr[0]-arr[1];
		arr[0] = arr[0]-arr[1];
	}

}
