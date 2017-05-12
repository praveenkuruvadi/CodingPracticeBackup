package leetCodeEasy;

public class searchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] blah = {-1,-1};
        if(nums.length==0)
            return blah;
        if(nums.length ==1){
            if(target == nums[0]){
                int[] x = {0,0};
                return x;
            }
            else
                return blah;
        }
        int top = topOrder(nums,target);
        int low = lowOrder(nums,target);
        int[] out= {low,top};
        return out;
        
    }
    
    public int lowOrder(int[] nums,int target){
        
        int out =-1;
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target)
                high = mid-1;
            else
                low = mid+1;
            if(nums[mid] == target)
                out = mid;
        }
        return out;
        
    }
    
    public int topOrder(int[] nums,int target){
        int out =-1;
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<=target)
                low = mid+1;
            else
                high = mid-1;
            if(nums[mid] == target)
                out = mid;
        }
        return out;
    }
}
