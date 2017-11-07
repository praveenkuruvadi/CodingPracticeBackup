package TreesNGraphs;

public class treeNode {
	int data;
	treeNode left;
	treeNode right;
	
	public treeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public treeNode(int data,treeNode left,treeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	

}
