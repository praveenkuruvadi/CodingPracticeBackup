package trieDataStructure;

import java.util.HashMap;

public class trieNode {
	private char data;
	private HashMap<Character, trieNode> childMap;
	private int count;
	private boolean isLeaf;
	
	public trieNode(char c){
		this.data =c;
		childMap = new HashMap<Character,trieNode>();
		this.count=0;
		this.isLeaf = Boolean.FALSE;
	}
	
	public HashMap<Character,trieNode> getChildMap(){
		return this.childMap;
	}
	
	public trieNode getChild(char c){
		if(!childMap.isEmpty()){
			if(childMap.containsKey(c))
				return childMap.get(c);
			return null;
		}
		return null;
	}
	public char getData(){
		return this.data;
	}
	
	public int getChildCount(){
		return this.count;
	}
	
	public boolean checkIfLeaf(){
		return this.isLeaf;
	}
	
	public void addChild(trieNode child){
		this.childMap.put(child.getData(), child);
		this.count++;
	}
	
	public void setAsLeaf(){
		this.isLeaf= Boolean.TRUE;
	}
	
	
}
