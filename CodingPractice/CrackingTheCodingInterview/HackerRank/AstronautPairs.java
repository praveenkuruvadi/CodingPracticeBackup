package HackerRank;

import java.util.Scanner;

class component{
	int parent;
	int rank;
	
	public component(int parent,int rank){
		this.parent = parent;
		this.rank = rank;
	}
}

public class AstronautPairs {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int country =1;
        int nodes[] = new int[n];
        int hold[] = new int[n];
        component[] components = new component[n];
        for(int i=0;i<components.length;i++)
			components[i]=new component(i,0);
        for(int i=0;i<p;i++){
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            if(find(components,p1)!= find(components,p2))
                union(components,p1,p2);
        }
        int pairCount=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(find(components,i)!=find(components,j))
                    pairCount++;
            }
        }
        System.out.println(pairCount);
    }
    
    private static void union(component[] components,int p1,int p2){
        int i1Root = find(components,p1);
        int i2Root = find(components,p2);
        if(components[i1Root].rank>components[i2Root].rank){
			components[i2Root].parent = components[i1Root].parent;
		}else if(components[i1Root].rank<components[i2Root].rank){
			components[i1Root].parent = components[i2Root].parent;
		}else{
			components[i2Root].parent = components[i1Root].parent;
			components[i1Root].rank++;
		}
    }
    
    
    private static int find(component[] components,int i){
        if(components[i].parent != i)
            components[i].parent= find(components, components[i].parent);
        return components[i].parent;
    }

}
