package redfin;

public class arrayMissingElem {
	
//	You are given an array of integers, a1, that have   sequential integers 1 through n. 
//	( { 1,2,3,4,5 } or { 1,2,3 } or any other array) You are also given an array of integers, a2, 
//	that also have numbers 1 through n, but are not in sequential order and 
//	are missing one of the numbers between 1 and n. Find the missing number in a2. 
//	Did you check for special cases? Can you do this in O(n) runtime? 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,2,3,4,5,6,7,8,9};
		int arr2[] = {8,1,5,6,2,4,3,7};
		int sum2=0;
		for(int i:arr2)
			sum2+=i;
		int sum1 = (arr1[arr1.length-1]*(arr1[arr1.length-1]+1))/2;
		System.out.println(sum1-sum2);

	}

}
