package leetCodeEasy;

import java.util.HashSet;

public class longestSubstring {
	//without repeating characters
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0,count=0,i=0;
        if(s.length()==0)
            return 0;
        HashSet<Character> set= new HashSet<Character>();
        while(i<s.length()){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(count++));
            }else{
                set.add(s.charAt(i++));
                maxLength= Math.max(maxLength,set.size());
            }
            
        }
        return maxLength;
       
    }

}
