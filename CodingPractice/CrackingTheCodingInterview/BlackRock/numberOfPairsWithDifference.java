package BlackRock;

import java.util.Arrays;

public class numberOfPairsWithDifference {
	  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
	    // your code goes here
	    int[][] output = new int[arr.length][2];
	    Arrays.sort(arr);
	    int p1 = 0;
	    int p2 = 1;
	    int count =0;
	    while(p2<arr.length && p1<arr.length ){
	      if(p1 == p2){
	        p2++;
	      }
	      else if(arr[p2]-arr[p1]== k){
	        output[count][0] = arr[p1];
	        output[count][1] = arr[p2];
	        count++;
	        p1++;
	        p2++;
	      }
	      else if(arr[p2]-arr[p1]< k){
	        p2++;
	      }
	      else if(arr[p2]-arr[p1]> k){
	        p1++;
	      }
	    }
	        
	     return output;
	    
	  }

	  public static void main(String[] args) {
	      int[] arr =  {0, -1, -2, 2, 1};
	      int k = 1;
	      int[][] out = findPairsWithGivenDifference(arr,k);
	      for(int i=0;i<out.length;i++){
	        System.out.println(out[i][0]+","+out[i][1]);
	      }
	  }
}