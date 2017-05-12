package leetCodeEasy;

public class twoSumArray {
	   public int[] twoSum(int[] numbers, int target) {
	        int lowerPtr = 0;
	        int higherPtr = numbers.length-1;
	        int sum = 0;
	        while(numbers[lowerPtr]+numbers[higherPtr] != target){
	            sum = numbers[lowerPtr]+numbers[higherPtr];
	            if(sum <target)
	                lowerPtr++;
	            else
	                higherPtr--;
	        }
	        int[] out = {lowerPtr+1,higherPtr+1};
	        return out;
	        
	    }

}
