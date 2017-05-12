package leetCodeEasy;

import java.util.HashMap;

public class majorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else{
                int val = map.get(nums[i]);
                map.put(nums[i],val+1);
            }
        }
        int elem =0;
        int maxVal=0;
        for(int key :map.keySet()){
            if(map.get(key)>maxVal){
                elem =key;
                maxVal= map.get(key);
            }
        }
        return elem;
    }

}
