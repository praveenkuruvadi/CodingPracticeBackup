package trees;

public class treeNode {
	private int data;
	private treeNode leftNode;
	private treeNode rightNode;
	
	public treeNode(int data){
		this.data = data;
		leftNode = null;
		rightNode = null;
	}
	
	public treeNode(int data,treeNode leftNode,treeNode rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public int getData(){
		return this.data;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public void setLeftNode(treeNode leftNode){
		this.leftNode =leftNode;
	}
	public void setRightNode(treeNode rightNode){
		this.rightNode = rightNode;
	}
	
	public treeNode getLeftNode(){
		return leftNode;
	}
	public treeNode getRightNode(){
		return rightNode;
	}

}
