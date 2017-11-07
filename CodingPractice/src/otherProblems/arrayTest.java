package otherProblems;

import java.util.Arrays;

public class arrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		System.out.println(arr);
		int[] arr2 = Arrays.copyOf(arr, 5);
		arr2[2] = 4;
		System.out.println(arr2[2]);
		System.out.println(arr[2]);
	}

}
