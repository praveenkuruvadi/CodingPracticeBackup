package redfin;

import java.util.Arrays;



class treeNode{
	int data;
	treeNode leftNode;
	treeNode rightNode;
	
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
}

class tree{
	treeNode root;
	int height;
	
	public tree(treeNode root){
		this.root = root;
	}
	
	private int getHeight(treeNode root) {
		if(root == null)
			return 0;
		else
			return 1+ Math.max(getHeight(root.leftNode),getHeight(root.rightNode)); 
	}
	
	public void add(treeNode root,int data){
		if(root.data> data){
			if(root.leftNode == null){
				root.leftNode= new treeNode(data);
			}
			else
				add(root.leftNode,data);
		}
		else if(root.data<data){
			if(root.rightNode== null){
				root.rightNode=new treeNode(data);
			}
			else
				add(root.rightNode,data);
		}
	}
}
public class bstMirrorCentralAxis {
	public static void main(String[] args){
		
	}

}
