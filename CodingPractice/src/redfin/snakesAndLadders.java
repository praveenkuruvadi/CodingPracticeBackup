package redfin;

import java.io.*;
import java.util.*;

class entry{
    int v;
    int moves;
    public entry(int v,int moves){
        this.v = v;
        this.moves = moves;
    }
    public entry(){
        
    }
}
public class snakesAndLadders {
    private static int[] moves;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());
        for(int i=0;i<cases;i++){
            moves = new int[100];
            Arrays.fill(moves,-1);
            int ladders = Integer.parseInt(in.nextLine());
            for(int j=0;j<ladders;j++){
                int x = in.nextInt();
                int y = in.nextInt();
                moves[x-1]=y-1;
                in.nextLine();
            }
            int snakes = Integer.parseInt(in.nextLine());
            for(int j=0;j<snakes;j++){
                int x = in.nextInt();
                int y = in.nextInt();
                moves[x-1]=y-1;
                if(in.hasNextLine())
                    in.nextLine();
            }
            System.out.println(getMin()-1);
        }
        
    }
    
    private static int getMin(){
        boolean[] visited = new boolean[100];
        Arrays.fill(visited,false);
        entry e = new entry(0,0);
        Queue<entry> queue = new LinkedList<entry>();
        queue.add(e);
        entry eout = new entry(0,0);
        while(!queue.isEmpty()){
            eout = queue.remove();
            if(eout.v == moves.length-1)
                break;
            if (!visited[eout.v]) {
                for (int i = (eout.v + 1); i <= (eout.v + 6); i++) {
                    entry enew = new entry();
                    enew.moves = eout.moves + 1;
                    if (moves[eout.v] == -1)
                        enew.v = i;
                    else enew.v = moves[eout.v];
                    visited[eout.v]=true;
                    queue.add(enew);
                }
            }
        }
        return eout.moves;
    }
}