package leetCodeEasy;

import java.util.ArrayList;
import java.util.HashSet;

public class intersectionArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int i =0;i<nums1.length;i++){
            if(!numbers.contains(nums1[i]))
                numbers.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(numbers.contains(nums2[i])){
                out.add(nums2[i]);
                numbers.remove(nums2[i]);
            }
        }
        int[] outArr = new int[out.size()];
        for(int i=0;i<out.size();i++){
            outArr[i]= out.get(i);
        }
        return outArr;
        
    }

}
