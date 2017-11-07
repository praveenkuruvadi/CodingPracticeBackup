package SortNSearch;

public class sortedMerge {
	//Look Backwards
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrA = {1,5,8,9,0,0,0,0};
		int[] arrB = {2,3,4,7};
		sortedMerge(arrA,arrB,3);
		for(int i:arrA)
			System.out.print(i+" ");

	}

	private static void sortedMerge(int[] arrA, int[] arrB,int mergePoint) {
		// TODO Auto-generated method stub
		int i=mergePoint,j=arrB.length-1;
		int out = arrA.length-1;
		
		while(out>=0){
			if(j<0){
				arrA[out--] = arrA[i];
				i--;
			}
			else if(i<0){
				arrA[out--] = arrB[j];
				j--;
			}else{
				if(arrA[i]<arrB[j]){
					arrA[out--]= arrB[j];
					j--;
				}else{
					arrA[out--]= arrA[i];
					i--;
				}
			}
		}
	}

}
