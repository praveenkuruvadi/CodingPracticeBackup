package leetCodeEasy;

public class IntPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int Original =x,val =x;
        int reverse=0;
        while(val !=0){
            reverse = reverse*10+ val%10;
            val = val/10;
        }
        if(reverse == Original)
            return true;
        else
            return false;
        
    }

}
