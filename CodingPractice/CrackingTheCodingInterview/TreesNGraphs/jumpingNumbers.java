package TreesNGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class jumpingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 40;
		getAllJumping(limit);

	}

	private static void getAllJumping(int limit) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=9&&i<=limit;i++)
			queue.add(i);
		System.out.println("");
		while(!queue.isEmpty()){
			int num = queue.remove();
			if(num<limit){
				System.out.print(num+" ");
				int lastPlace = num%10;
				if(lastPlace == 0)
					queue.add(num*10+(lastPlace+1));
				else if(lastPlace == 9)
					queue.add(num*10+(lastPlace-1));
				else{
					queue.add(num*10+(lastPlace+1));
					queue.add(num*10+(lastPlace-1));
				}
			}
		}
		
	}

}
