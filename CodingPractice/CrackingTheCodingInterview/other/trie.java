package other;

import java.util.ArrayList;
import java.util.HashMap;

class trieNode{
	private char data;
	private HashMap<Character,trieNode> children;
	private boolean isLeaf;
	int size;
	public trieNode(char ch){
		this.data = ch;
		this.children = new HashMap<Character,trieNode>();
		this.isLeaf = false;
		this.size =0;
	}
	
	public char getData(){
		return this.data;
	}
	
	public HashMap<Character,trieNode> getChildren(){
		return this.children;
	}
	
	public boolean checkIsLeaf(){
		return this.isLeaf;
	}
	
	public void setIsLeaf(boolean flag){
		this.isLeaf = flag;
	}
}

public class trie {
	private trieNode root;
	
	public trie(){
		this.root = new trieNode((char)0);
	}
	
    public void insert(String word){
		char[] arr = word.toCharArray();
		trieNode curr = this.root;
		for(int i=0;i<arr.length;i++){
			if(curr.getChildren().containsKey(arr[i])){
                curr = curr.getChildren().get(arr[i]);
                curr.size++;
            }
			else{
				trieNode temp = new trieNode(arr[i]);
                temp.size = 1;
				curr.getChildren().put(arr[i], temp);
				curr =temp;
			}
		}
		curr.setIsLeaf(true);
	}
    
    public int findCount(String prefix){
        int words = 0;
        trieNode curr = this.root;
        char[] arr = prefix.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(curr.getChildren().containsKey(arr[i]))
                curr = curr.getChildren().get(arr[i]);
            else
                return 0;
        }
        return curr.size;
    }
	
	public ArrayList<String> getSuggestions(String prefix) throws Exception{
		if(prefix.length()<3)
			throw new Exception("Too short prefix");
		if(!this.searchPrefix(prefix))
			throw new Exception("Prefix not present");
		ArrayList<String> out = new ArrayList<String>();
		
		char[] arr = prefix.toCharArray();
		trieNode curr = this.root;
		for(int i=0;i<arr.length;i++){
			curr = curr.getChildren().get(arr[i]);
		}
		getAllWords(curr,prefix.substring(0, prefix.length()-1),out);
		return out;
	}
	
	private void getAllWords(trieNode curr, String addWord, ArrayList<String> out) {
		// TODO Auto-generated method stub
		if(curr.checkIsLeaf())
			out.add(addWord+String.valueOf(curr.getData()));
		if(curr.getChildren().size()==0)
			return;
		String wordToSend = addWord+ String.valueOf(curr.getData());
		for(char key:curr.getChildren().keySet())
			getAllWords(curr.getChildren().get(key),wordToSend,out);
	}

	public boolean search(String word){
		char[] arr = word.toCharArray();
		trieNode curr = this.root;
		
		for(int i=0;i<arr.length;i++){
			if(curr.getChildren().containsKey(arr[i]))
				curr = curr.getChildren().get(arr[i]);
			else
				return false;
		}
		return curr.checkIsLeaf();
	}
	
	public boolean searchPrefix(String prefix){
		char[] arr = prefix.toCharArray();
		trieNode curr = this.root;
		
		for(int i=0;i<arr.length;i++){
			if(curr.getChildren().containsKey(arr[i]))
				curr = curr.getChildren().get(arr[i]);
			else
				return false;
		}
		return true;
	}
	

}
