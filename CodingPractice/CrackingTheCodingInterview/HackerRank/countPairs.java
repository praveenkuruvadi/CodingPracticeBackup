package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class countPairs {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int k= in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = in.nextInt();
        System.out.println(pairCount(arr,k));
    }
    
    private static int pairCount(int[] arr,int k){
        if(arr.length==1)
            return 0;
        Arrays.sort(arr);
        int i=0,j=1;
        int pair =0;
        while(j<arr.length){
            if(arr[j]-arr[i]==k){
                pair++;
                i++;j++;
            }else if(arr[j]-arr[i]>k)
                i++;
            else
                j++;
        }
        return pair;
    }

}
