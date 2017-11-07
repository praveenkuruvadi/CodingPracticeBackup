package TreesNGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class graphTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(4);
		try {
			graph.addEdge(0, 1, 1);
			graph.addEdge(0, 2, 1);
			graph.addEdge(2, 0, 1);
			graph.addEdge(1, 2, 1);
			graph.addEdge(2, 3, 1);
			System.out.println("DFS:");
			dfsSearch(graph.getNode(2));
			graph.resetVisits();
			System.out.println("BFS:");
			bfsSearch(graph.getNode(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void bfsSearch(graphNode node) throws Exception {
		// TODO Auto-generated method stub
		Queue<graphNode> queue = new LinkedList<graphNode>();
		Queue<graphNode> tempQueue = new LinkedList<graphNode>();
		queue.add(node);
		try{
			while(!queue.isEmpty()){
				while(!queue.isEmpty()){
					graphNode visit = queue.remove();
					if(!visit.isVisited()){
						visit.setVisited(true);
						System.out.print(visit.getId()+" ");
						for(graphNode nbr:visit.getNbrs()){
							if(!nbr.isVisited())
								tempQueue.add(nbr);
						}
					}
				}
				queue= tempQueue;
				tempQueue = new LinkedList<graphNode>();
				System.out.println("");;
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public static void dfsSearch(graphNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		node.setVisited(true);
		System.out.println(node.getId());
		for(graphNode visit:node.getNbrs()){
			if(!visit.isVisited())
				dfsSearch(visit);
		}
	}
	
	

}
