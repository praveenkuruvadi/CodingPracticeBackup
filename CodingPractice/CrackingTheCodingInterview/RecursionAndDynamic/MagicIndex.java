package RecursionAndDynamic;

public class MagicIndex {
	//////Find index such that A[i]=i in sorted array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-40,-20,-1,1,2,3,5,7,9,12,13};
		int magicIndex = findMagicIndex(input,0,input.length-1);
		System.out.println("Element at "+magicIndex +" is: "+input[magicIndex]);

	}

	private static int findMagicIndex(int[] input, int left, int right) {
		// TODO Auto-generated method stub
		int mid = (left+right)/2;
		if(input[mid]==mid)
			return mid;
		else if(input[mid]>mid)
			return findMagicIndex(input,left,mid-1);
		else
			return findMagicIndex(input,mid+1,right);
	}

}
