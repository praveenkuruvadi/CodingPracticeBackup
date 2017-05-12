package trieDataStructure;

public class trieDriver {

	public static void main(String[] args) {
		trie t = new trie();
		t.insert("told");
		t.insert("took");
		//t.insert("book");
		//t.insert("bold");
		
		trieNode t1 = t.getRoot();
		System.out.println(t1.getChildMap().size());
		trieNode t2= t1.getChild('l');
		System.out.println(t2.getData());
		System.out.println("Root Children: "+t.getRoot().getChildCount());
		System.out.println("Number of words: "+t.getWordCount());
		System.out.println("Search test: "+t.search("took"));

	}

}
