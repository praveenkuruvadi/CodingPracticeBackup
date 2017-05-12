package redfin;

import java.util.Arrays;
import java.util.Scanner;

public class minDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        int min =a[a.length-1];
        for(int i=1;i<a.length;i++){
                if(Math.abs(a[i]-a[i-1])<min)
                    min = Math.abs(a[i]-a[i-1]);
        }
        // your code goes here
        System.out.println(min);
    }

}
