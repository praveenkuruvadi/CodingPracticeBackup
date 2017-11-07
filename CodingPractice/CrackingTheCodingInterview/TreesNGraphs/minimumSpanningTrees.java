package TreesNGraphs;

import java.util.ArrayList;
import java.util.Collections;

class component{
	int parent;
	int rank;
	
	public component(int parent,int rank){
		this.parent = parent;
		this.rank = rank;
	}
}

public class minimumSpanningTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph graph = new Graph(9);
		
		try{
			graph.addEdge(0, 1, 4);
			graph.addEdge(1, 2, 8);
			graph.addEdge(2, 3, 7);
			graph.addEdge(3, 4, 9);
			graph.addEdge(4, 5, 10);
			graph.addEdge(3, 5, 14);
			graph.addEdge(5, 2, 4);
			graph.addEdge(5, 6, 2);
			graph.addEdge(6, 7, 1);
			graph.addEdge(6, 8, 6);
			graph.addEdge(7, 8, 7);
			graph.addEdge(2, 8, 2);
			graph.addEdge(7, 1, 11);
			graph.addEdge(0, 7, 8);
			System.out.println("BFS of Graph: ");
			graphTraversals.bfsSearch(graph.getNode(0));
			System.out.println("Kruskal MST:");
			kruskalMst(graph);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}

	}

	public static void kruskalMst(Graph graph) {
		// TODO Auto-generated method stub
		component[] components = new component[graph.getSize()];
		for(int i=0;i<components.length;i++)
			components[i]=new component(i,0);
		ArrayList<Edge> edgeList = (ArrayList<Edge>) graph.getEdges();
		Collections.sort(edgeList,(o1,o2)->o1.weight-o2.weight);
		for(Edge edge:edgeList){
			if(addEdgeToTree(components,edge))
				System.out.println(edge.start.getId()+" to "+edge.end.getId()+" Wt: "+edge.weight);
		}
	}
	
	private static boolean addEdgeToTree(component[] components, Edge edge) {
		// TODO Auto-generated method stub
		if(find(components,edge.start.getId())==find(components,edge.end.getId()))
			return false;
		union(components,edge.start.getId(),edge.end.getId());
		return true;
	}
	
	private static void union(component[] components, int i1, int i2) {
		// TODO Auto-generated method stub
		int i1Root = find(components,i1);
		int i2Root = find(components,i2);
		if(components[i1Root].rank>components[i2Root].rank){
			components[i2Root].parent = components[i1Root].parent;
		}else if(components[i1Root].rank<components[i2Root].rank){
			components[i1Root].parent = components[i2Root].parent;
		}else{
			components[i2Root].parent = components[i1Root].parent;
			components[i1Root].rank++;
		}
	}

	private static int find(component[] components, int i){
		if(components[i].parent != i)
			components[i].parent= find(components,components[i].parent);
		return components[i].parent;
	}

}
