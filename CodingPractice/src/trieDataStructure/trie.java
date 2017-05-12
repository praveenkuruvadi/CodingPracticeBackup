package trieDataStructure;

public class trie {
	
	private trieNode root;
	private int wordCount;
	
	public trie(){
		this.root = new trieNode(' ');
		this.wordCount=0;
	}
	
	public int getWordCount(){
		return this.wordCount;
	}
	
	public void insert(String word){
		if(search(word))
			return;
		trieNode current = root;
		for(char c:word.toCharArray()){
			if(root.getChild(c)!=null)
				current = root.getChild(c);
			else{
				current.addChild(new trieNode(c));
				current = current.getChild(c);
			}
		}
		current.setAsLeaf();
		wordCount++;
	}
	
	public boolean search(String word){
		if(root.getChildMap().isEmpty())
			return false;
		trieNode current = root;
		for(char c: word.toCharArray()){
			if(current.getChild(c)!=null){
				System.out.println(c);
				current = current.getChild(c);
			}
			else
				return false;
		}
		System.out.println("HERE: "+current.getData());
		if(current.checkIfLeaf())
			return true;
		return false;
	}
	
	public trieNode getRoot(){
		return this.root;
	}

}
