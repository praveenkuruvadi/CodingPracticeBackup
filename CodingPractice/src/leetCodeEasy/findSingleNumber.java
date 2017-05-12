package leetCodeEasy;

import java.util.HashSet;
import java.util.Iterator;



public class findSingleNumber {
    public int singleNumber(int[] nums) {
        
        HashSet<Integer> count = new HashSet<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(count.contains(nums[i]))
                count.remove(nums[i]);
            else
                count.add(nums[i]);
        }
        Iterator iterator = count.iterator();
        while(iterator.hasNext()){
            return (Integer)iterator.next();
        }
        return 0;
    }

}
