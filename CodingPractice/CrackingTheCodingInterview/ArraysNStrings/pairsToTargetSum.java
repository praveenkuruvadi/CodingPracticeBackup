package ArraysNStrings;

import java.util.Arrays;

public class pairsToTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 5, 7, -1};
		int target = 6;
		System.out.println("Pairs equalling target: "+ pairsSumToTarget(arr,target));

	}

	private static int pairsSumToTarget(int[] arr, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int i=0,j=arr.length-1,temp = 0,count=0;
		while(i<j){
			temp = arr[i]+arr[j];
			if(temp==target){
				count++;
				System.out.println("("+arr[i]+","+arr[j]+")");
				i++;
				j--;
			}
			else if(temp<target)
				i++;
			else
				j--;
		}
		return count;
	}

}
