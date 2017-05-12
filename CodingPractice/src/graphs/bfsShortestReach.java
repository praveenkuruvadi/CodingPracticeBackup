package graphs;

import java.io.*;
import java.util.*;

class bfsnode{
    int nodeId;
    ArrayList<bfsnode> nbrs;
    boolean visited;
    public bfsnode(int nodeId){
        this.nodeId = nodeId;
        this.nbrs = new ArrayList<bfsnode>();
        this.visited = false;
    }
    
    public void addnbr(bfsnode n){
        this.nbrs.add(n);
    }
    
}
public class bfsShortestReach {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();
        in.nextLine();
        for(int i=0;i<query;i++){
            int nodes = in.nextInt();
            int edges = in.nextInt();
            in.nextLine();
            ArrayList<bfsnode> nodeList = new ArrayList<bfsnode>();
            for(int j=0;j< nodes;j++)
                nodeList.add(new bfsnode(j+1));
            for(int j=0;j<edges;j++){
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                in.nextLine();
                nodeList.get(n1-1).addnbr(nodeList.get(n2-1));
                nodeList.get(n2-1).addnbr(nodeList.get(n1-1));
            }
            int start = in.nextInt();
            if(in.hasNextLine())
                in.nextLine();
            int[] out = getDist(nodeList.get(start-1),nodeList.size());
            for(int j=0;j<out.length;j++){
                if(j!=start-1)
                    System.out.print(out[j]+" ");
            }
            System.out.println("");
        }
    }
    
    private static int[] getDist(bfsnode start,int size){
        int[] map = new int[size];
        Arrays.fill(map,-1);
        int level =1;
        Queue<bfsnode> currLevel = new LinkedList<bfsnode>();
        Queue<bfsnode> nextLevel = new LinkedList<bfsnode>();
        currLevel.add(start);
        while(!currLevel.isEmpty()){
            Iterator<bfsnode> itr = currLevel.iterator();
            while(itr.hasNext()){
            	bfsnode temp = currLevel.poll();
                ArrayList<bfsnode> nbrTest = temp.nbrs;
                for(bfsnode n: nbrTest){
                    if(!n.visited){
                        n.visited=true;
                        map[n.nodeId-1]= level*6;
                        nextLevel.add(n);
                    }
                }
            }
            level++;
            currLevel = nextLevel;
            nextLevel = new LinkedList<bfsnode>();
        }
        return map;
    }
}