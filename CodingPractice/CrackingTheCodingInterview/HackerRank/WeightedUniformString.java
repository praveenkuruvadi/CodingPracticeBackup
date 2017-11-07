package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class WeightedUniformString {

    private static HashSet<Integer> set;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        processString(s);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here
            if(set.contains(x))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    
    private static void processString(String s){
        set = new HashSet<Integer>();
        char[] arr = s.toCharArray();
        int count = 1;
        for(int i=0;i<arr.length;i++){
            count = 1;
            set.add((int)arr[i]-'a'+1);
            if(i!=arr.length-1){
                while(arr[i]==arr[i+1]){
                count+=1;
                set.add(count*((int)arr[i]-'a'+1));
                i+=1;
                if(i==arr.length-1)
                    break;
            }
            }
            
        }
    }

}
