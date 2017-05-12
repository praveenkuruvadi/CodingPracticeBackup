package codingInterview;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class equilibruimArray {

    static String solve(int[] a){
        int sum=0,left=0;
        for(int i=0;i<a.length;i++)
            sum+=a[i];
        for(int i=0;i<a.length;i++){
            sum-=a[i];
            if(sum==left)
                return "YES";
            left+=a[i];
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}