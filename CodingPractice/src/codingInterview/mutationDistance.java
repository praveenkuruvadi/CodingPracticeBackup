package codingInterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class mutationDistance {
	public static void main(String[] args){
		
	}
	public static int findMutationDistance(String start, String end, String[] bank) {
        if(start.equals(end)) 
            return 0;
        
        HashSet<String> set = new HashSet<String>();
        for(String dna: bank) 
        	set.add(dna);
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int changes = 0;
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return changes;
                
                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            changes++;
        }
        return -1;
    }


    }

