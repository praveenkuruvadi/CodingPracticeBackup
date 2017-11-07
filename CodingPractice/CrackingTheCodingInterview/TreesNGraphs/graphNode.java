package TreesNGraphs;

import java.util.ArrayList;

public class graphNode {
	private int id;
	private boolean isVisited;
	private ArrayList<graphNode> nbrs;
	
	public graphNode(int id){
		this.id = id;
		this.isVisited = Boolean.FALSE;
		this.nbrs = new ArrayList<graphNode>();
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public ArrayList<graphNode> getNbrs() {
		return nbrs;
	}

	public void addNbr(graphNode nbr) {
		this.nbrs.add(nbr);
	}

	public int getId() {
		return id;
	}
}
