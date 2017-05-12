package leetCodeEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class topKFrequencyItems {
	   public List<Integer> topKFrequent(int[] nums, int k) {
	        
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i=0;i< nums.length;i++){
	            if(map.containsKey(nums[i])){
	                int val= map.get(nums[i]);
	                map.put(nums[i],val+1);
	                
	            }else{
	                map.put(nums[i],1);
	            }
	        }
	        
	        List<Integer>[] list = new List[nums.length+1];
	        for(int key:map.keySet()){
	            int val = map.get(key);
	            if(list[val] == null){
	                list[val] = new ArrayList<Integer>();
	                list[val].add(key);
	            }else{
	                list[val].add(key);
	            }
	        }
	        int count = k;
	        List<Integer> listReturn = new ArrayList<Integer>();
	        for(int i=nums.length;i>0;i--){
	            if(list[i]!= null){
	                List<Integer> numbers = list[i];
	                for(int x:numbers){
	                    if(count==0)
	                        break;
	                    listReturn.add(x);
	                    count--;
	                }
	                if(count==0)
	                    break;
	            }
	        }
	        return listReturn;
	        
	    }

}
