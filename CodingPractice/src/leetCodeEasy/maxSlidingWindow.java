package leetCodeEasy;

import java.util.ArrayList;

public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i =0;i< nums.length-k+1;i++){
            int max =Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(max<nums[j])
                    max=nums[j];
            }
            list.add(max);
        }
        int[] out = new int[list.size()];
        for(int i=0;i<list.size();i++)
            out[i]=list.get(i);
        
        return out;
    }

}
