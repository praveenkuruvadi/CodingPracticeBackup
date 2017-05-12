package graphs;


import java.io.*;
import java.util.*;

class dnode{
    int v;
    HashMap<Integer,dnode> nbrs;
    
    public dnode(int node_id){
        this.v = node_id;
        nbrs = new HashMap<Integer,dnode>();
    }
}

public class decomposeEvenTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int nodes = in.nextInt();
        int edges = in.nextInt();
        in.nextLine();
        dnode[] nodeList = new dnode[nodes+1];
        for(int i=1;i<=nodes;i++){
            nodeList[i] = new dnode(i);
        }
        for(int i=0;i<edges;i++){
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            if(v1<v2)
                nodeList[v1].nbrs.put(v2,nodeList[v2]);
            else
                nodeList[v2].nbrs.put(v1,nodeList[v1]);
            if(in.hasNextLine())
                in.nextLine();
        }
        int[] output = decompose(nodeList[1]);
        System.out.println(output[1]);
    }
    
    private static int[] decompose(dnode root){
        int count=0,edges=0;
        
        for(int i: root.nbrs.keySet()){
            int[] temp =decompose(root.nbrs.get(i));
            if(temp[0]%2==0)
                edges++;
            else
                count+= temp[0];
        }
        count++;
        return new int[]{count,edges};
        
    }
}