package leetCodeEasy;

import java.util.HashSet;

public class longestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int len=0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                len=len+2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(set.isEmpty())
            return len;
        else
            return len+1;
    }

}
