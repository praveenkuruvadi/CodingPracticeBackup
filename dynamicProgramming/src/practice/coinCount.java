//package practice;
//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class coinCount {
//    public static void main(String[] args) throws Exception{
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line1 = br.readLine().split(" ");
//        int total = Integer.parseInt(line1[0]);
//        int m = Integer.parseInt(line1[1]);
//        String[] line2 = br.readLine().split(" ");
//        int coins[] = new int[m];
//        for(int i=0;i<m;i++){
//            coins[i]= Integer.parseInt(line2[i]);
//        }
//        int lookup[][] =new int[coins.length+1][total+1];
//        for(int i=0;i<=coins.length;i++){
//            for(int j=0;j<=total;j++){
//                lookup[0][j]=0;
//                lookup[i][0]=1;
//                if(i>=1&&j>=1){
//                    if(j>=coins[i-1]){
//                        lookup[i][j]=lookup[i-1][j]+lookup[i][j-coins[i-1]];
//                    }else
//                        lookup[i][j]=lookup[i-1][j];
//                }
//            }
//        }
//        System.out.println(lookup[coins.length][total]);
//
//        
//    }
//}
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                        