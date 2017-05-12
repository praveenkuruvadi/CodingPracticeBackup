package graphs;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class primedge{
        int v1,v2, dist;
        public primedge(int v1, int v2, int dist){
            this.v1=v1;
            this.v2=v2;
            this.dist=dist;
        }
    }
public class primMst {
    
    private static int[] components;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int nodeNum = in.nextInt();
        components = new int[nodeNum];
        for(int i=0;i<nodeNum;i++)
            components[i]=0;
        int com=0;
        int edgeNum = in.nextInt();
        in.nextLine();
        
        PriorityQueue<primedge> queue = new PriorityQueue<primedge>(1, new Comparator<primedge>(){
            public int compare(primedge e1,primedge e2){
                return e1.dist - e2.dist;
            }
        });
        
        for(int i=0;i<edgeNum;i++){
            String[] data = in.nextLine().split(" ");
            primedge eadd = new primedge(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            queue.add(eadd);
        }
        int totalWeight=0;
        while(!checkComponents()){
        	primedge eout = queue.poll();
            if(components[eout.v1-1]==0 && components[eout.v2-1]==0){
                totalWeight+= eout.dist;
                com++;
                components[eout.v1-1]=com;
                components[eout.v2-1]=com;
            }
            else if((components[eout.v1-1]== 0 && components[eout.v2-1]!=0)||
                    (components[eout.v1-1]!= 0 && components[eout.v2-1]==0)){
                totalWeight+= eout.dist;
                if(components[eout.v1-1]== 0)
                    components[eout.v1-1]=components[eout.v2-1];
                else
                    components[eout.v2-1]=components[eout.v1-1];
            }
            else if(components[eout.v1-1]!= components[eout.v2-1]){
                totalWeight+= eout.dist;
                if(components[eout.v1-1]>components[eout.v2-1]){
                    updateComponents(components[eout.v2-1],components[eout.v1-1],components[eout.v1-1]);
                }else{
                    updateComponents(components[eout.v2-1],components[eout.v1-1],components[eout.v2-1]);
                }
            }
        }
        System.out.println(totalWeight);
    }
    private static void updateComponents(int com1,int com2, int val){
        for(int i=0;i<components.length;i++){
            if(components[i] == com1 || components[i] == com2  )
                components[i]=val;
        }
    }
    private static boolean checkComponents(){
        int val =components[0];
        for(int i:components){
            if(i!=val || i==0)
                return false;
        }
        return true;    
    }
}