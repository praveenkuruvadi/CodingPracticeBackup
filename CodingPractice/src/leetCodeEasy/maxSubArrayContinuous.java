package leetCodeEasy;

public class maxSubArrayContinuous {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length-1 ==0)
            return nums[0];
        int maxSoFar =nums[0];
        int maxEndHere =nums[0];
        for(int i=1;i<nums.length;i++){
            maxEndHere = Math.max(nums[i],maxEndHere + nums[i]);
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar;
    }

}
