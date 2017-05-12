package sorts;

public class binarySearchIterative {

	public static void main(String[] args) {
		int[] arr = {2,4,6,7,8,9};
		System.out.println(binarySearch(9,arr));

	}
	
	private static String binarySearch( int searchElem, int[] array){
		int low =0, high= array.length-1;
		int mid=0;
		while(low<high){
			mid =  (low+high)/2;
			if(array[mid] == searchElem)
				return "present at "+mid;
			else if(array[mid] >searchElem)
				low = mid+1;
			else if(array[mid] <searchElem)
				high=mid-1;

		}
			return "not present" ;
		}

}
