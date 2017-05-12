package leetCodeEasy;

public class duplicatesInArrayInPlace {
    public int removeDuplicates(int[] nums) {
        if(nums.length ==0)
            return 0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!= nums[count])
                nums[++count]=nums[i];
            
        }
        return ++count;  
    }

}
