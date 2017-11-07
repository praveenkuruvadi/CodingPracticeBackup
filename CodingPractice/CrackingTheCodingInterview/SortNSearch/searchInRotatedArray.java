package SortNSearch;

public class searchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(search(input,0,input.length-1,5));
	}

	private static int search(int[] input, int left, int right, int elem) {
		// TODO Auto-generated method stub
		int mid = (left+right)/2;
		if(input[mid]==elem)
			return mid;
		else if(left>right)
			return -1;
		else if(input[mid]<input[right] && input[mid]<elem && input[right]>elem)
			return search(input,mid+1,right,elem);
		else if(input[mid]>input[left] && input[mid]>elem && input[left]<elem)
			return search(input,left,mid-1,elem);
		else if(input[mid]<input[left] && elem>input[left])
			return search(input,left,mid-1,elem);
		else if(input[mid]>input[right] && elem<input[right])
			return search(input,mid+1,right,elem);
		else 
			return -1;
	}

}
