package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree {
	private treeNode root;
	
	public tree(treeNode root){
		this.root = root;
	}
	
	public treeNode getRoot(){
		return this.root;
	}
	
	public int getHeight(){
		int height = heightTrace(this.root);
		return height;
	}
	
	private int heightTrace(treeNode root) {
		if(root == null)
			return 0;
		else
			return 1+ Math.max(heightTrace(root.getLeftNode()),heightTrace(root.getRightNode())); 
		
	}

	public void add(treeNode root,int data){
		if(root.getData()> data){
			if(root.getLeftNode() == null){
				root.setLeftNode(new treeNode(data));
			}
			else
				add(root.getLeftNode(),data);
		}
		else if(root.getData()<data){
			if(root.getRightNode()== null){
				root.setRightNode(new treeNode(data));
			}
			else
				add(root.getRightNode(),data);
		}
	}
	

	public boolean searchBST(treeNode root, int data) {
		if(root== null)
			return false;
		else if(root.getData() == data)
			return true;
		else if(data<root.getData())
			searchBST(root.getLeftNode(),data);
		else if(data>root.getData())
			searchBST(root.getRightNode(),data);
		return false;
	}

	public void delete(int data){
		treeNode parent = null,current = this.root;
		String side ="";
		if(root == null){
			System.out.println("Empty Tree");
			return;
		}
		while(current.getData() != data){
			//System.out.println(current.getData());
			if(current.getData()<data){
				parent = current;
				current = current.getRightNode();
				side="right";
			}
			else{
				parent=current;
				current = current.getLeftNode();
				side ="left";
			}	
		}
		if(current.getLeftNode() == null && current.getRightNode() == null&& parent.getRightNode() == current)
			parent.setRightNode(null);
		else if(current.getLeftNode() == null && current.getRightNode() == null&& parent.getLeftNode() == current)
			parent.setLeftNode(null);
		else if(current.getLeftNode()!=null && current.getRightNode() == null && parent.getRightNode() == current)
			parent.setRightNode(current.getLeftNode());
		else if(current.getLeftNode()!=null && current.getRightNode() == null && parent.getLeftNode() == current)
			parent.setLeftNode(current.getLeftNode());
		else if(current.getLeftNode()==null && current.getRightNode() != null && parent.getRightNode() == current)
			parent.setRightNode(current.getRightNode());
		else if(current.getLeftNode()==null && current.getRightNode() != null && parent.getLeftNode() == current)
			parent.setLeftNode(current.getRightNode());
		else{
			System.out.println(current.getData());
			replaceWithMin(current);
		}
	}

	private void replaceWithMin(treeNode current) {
		treeNode currMin = current.getRightNode();
		if(currMin.getLeftNode()!=null){
			System.out.println(currMin.getData());
			currMin = currMin.getLeftNode();
		}
		System.out.println(currMin.getData());
		
	}

	public void dfs(treeNode root){
		
	}
	
	public void bfs(treeNode root){
		Queue<treeNode> currLevel = new LinkedList<treeNode>();
		Queue<treeNode> nextLevel = new LinkedList<treeNode>();
		currLevel.add(this.root);
		while(!currLevel.isEmpty()){
			Iterator<treeNode> itr = currLevel.iterator();
			while(itr.hasNext()){
				treeNode temp = currLevel.poll();
				System.out.print(temp.getData()+" ");
				if(temp.getLeftNode()!=null)
					nextLevel.add(temp.getLeftNode());
				if(temp.getRightNode() != null)
					nextLevel.add(temp.getRightNode());
			}
			System.out.println("");
			currLevel= nextLevel;
			nextLevel= new LinkedList<treeNode>();
		}
	}
	
	public void spinalOrder(treeNode root){
		Queue<treeNode> currLevel = new LinkedList<treeNode>();
		Queue<treeNode> nextLevel = new LinkedList<treeNode>();
		currLevel.add(this.root);
		int level =1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!currLevel.isEmpty()){
			Iterator<treeNode> itr = currLevel.iterator();
			list = new ArrayList<Integer>();
			while(itr.hasNext()){
				treeNode temp = currLevel.poll();
				list.add(temp.getData());
				//System.out.print(temp.getData()+" ");
				if(temp.getLeftNode()!=null)
					nextLevel.add(temp.getLeftNode());
				if(temp.getRightNode() != null)
					nextLevel.add(temp.getRightNode());
			}
			if(level%2 ==0){
				for(int i=list.size()-1;i>=0;i--)
					System.out.print(list.get(i)+" ");
			}else{
				for(int i=0;i<list.size();i++)
					System.out.print(list.get(i)+" ");
			}
			level++;
			currLevel= nextLevel;
			nextLevel= new LinkedList<treeNode>();
		}
	}

	
	public void inorderTraversal(treeNode root){
		if(root == null)
			return;
		inorderTraversal(root.getLeftNode());
		System.out.println(root.getData());
		inorderTraversal(root.getRightNode());
	}
	
	public void postOrder(treeNode root){
		if(root == null)
			return;
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		System.out.println(root.getData());
	}
	
	public void preOrder(treeNode root){
		if(root == null)
			return;
		System.out.println(root.getData());
		preOrder(root.getLeftNode());
		preOrder(root.getRightNode());
	}

}
