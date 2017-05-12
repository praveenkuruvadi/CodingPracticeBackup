package redfin;

import java.util.HashMap;
import java.util.HashSet;

public class shortestSubarray {
	
	///given 2 arrays a and b find smallest subarray in a where all elements of b exist
	private static int[] arrA ={1 ,2, 5, 8, 7, 6, 2, 6, 5, 3, 8, 7};
	private static int[] arrB ={5,7};
	public static void main(String[] args) {
		int minLength=Integer.MAX_VALUE,finalLeft=0,finalRight=0;
		HashSet<Integer> elementsB = new HashSet<Integer>();
		HashSet<Integer> checkingB = new HashSet<Integer>();
		initializeSet(elementsB);
		initializeSet(checkingB);
		HashMap<Integer,Integer> rightMost = new HashMap<Integer,Integer>();
		int rightPtr=0,leftPtr=0;
		
		while(rightPtr<arrA.length){
			if(checkingB.contains(arrA[rightPtr])){
				elementsB.remove(arrA[rightPtr]);
				rightMost.put(arrA[rightPtr], rightPtr);
				if(elementsB.isEmpty()){
					while(!checkingB.contains(arrA[leftPtr])||
							checkingB.contains(arrA[leftPtr])&& rightMost.get(arrA[leftPtr])>leftPtr){
						leftPtr++;
					}
					if(rightPtr-leftPtr<minLength){
						minLength= rightPtr-leftPtr+1;
						finalLeft=leftPtr;
						finalRight=rightPtr;
					}
					rightPtr++;
					leftPtr=rightPtr;
					rightMost= new HashMap<Integer,Integer>();
					initializeSet(elementsB);
				}else
					rightPtr++;
			}else
				rightPtr++;
		}
		
		System.out.println("Min subarray length:"+minLength);
		System.out.println("Subarray:");
		for(int i = finalLeft;i<=finalRight;i++){
			System.out.print(arrA[i]+" ");
		}
		

	}
	
	private static void initializeSet(HashSet<Integer> set){
		for(int i:arrB)
			set.add(i);
	}

}
