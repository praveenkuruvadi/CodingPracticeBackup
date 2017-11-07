package codingInterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class entry{
    int row;
    int c1;
    int c2;
    int n;
    int m;
    int freeCells;
    public entry(int row,int c1, int c2,int n,int m){
        this.row = row;
        this.c1 = c1;
        this.c2 = c2;
        this.n = n;
        this.m =m;
        this.freeCells = this.m - (this.c2-this.c1 +1);
    }
    
    public void updateEntry(int c1new, int c2new){
        if(c1new>this.c1 && c2new<this.c2)
            return;
        if((c1new<this.c1 && c2new<this.c1)||(c1new>this.c2 && c2new>this.c2))
            this.freeCells = this.freeCells - (c2new-c1new +1);
        else{
            this.c1 = c1new<this.c1?c1new:this.c1;
            this.c2 = c2new>this.c2?c2new:this.c2;
            this.freeCells = this.m - (this.c2-this.c1 +1);
        }
    }
    
}


public class lampostGrid {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BigInteger cells = BigInteger.valueOf(0);
        HashMap<Integer,entry> map = new HashMap<Integer,entry>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int row;
        for(int i=0;i<k;i++){
            row = in.nextInt();
            if(map.containsKey(row)){
                map.get(row).updateEntry(in.nextInt(),in.nextInt());
            }else{
                map.put(row,new entry(row,in.nextInt(),in.nextInt(),n,m));
            }
        }
        for(int i=1;i<=n;i++){
            if(map.containsKey(i))
                cells = cells.add(BigInteger.valueOf(map.get(i).freeCells));
            else
                cells = cells.add(BigInteger.valueOf(m));
        }
        System.out.println(cells);
    }
}
