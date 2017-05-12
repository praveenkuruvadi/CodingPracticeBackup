package redfin;

import java.util.HashMap;
import java.util.Scanner;

public class sherlockString {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int i=0;i<word.length();i++){
            if(map.containsKey(word.charAt(i)))
                map.put(word.charAt(i),map.get(word.charAt(i))+1);
            else
                map.put(word.charAt(i),1);
        }
        for(char c:map.keySet()){
            if(map2.containsKey(map.get(c)))
                map2.put(map.get(c),map2.get(map.get(c))+1);
            else
                map2.put(map.get(c),1);
        }
        if(map2.size()>2)
            System.out.println("NO");
        else if(map2.size()==2){
            int[] val = new int[2];
            int j=0;
            for(int i:map2.keySet())
                val[j++]=i;
            if(Math.abs(val[0]-val[1])>1)
                System.out.println("NO");
            else{
                if(map2.get(val[0])>1&&map2.get(val[1])>1)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }
        }else
            System.out.println("YES");
            
    }

}
