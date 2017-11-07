package TreesNGraphs;

import java.util.HashSet;

class CharNode{
	char ch;
	CharNode left;
	CharNode right;
	
	public CharNode(char ch){
		this.ch = ch;
		this.left = null;
		this.right = null;
	}
}

public class duplicateSubtree {
	static HashSet<String> holdmap = new HashSet<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharNode root = new CharNode('A');
		root.left = new CharNode('B');
		root.left.left = new CharNode('D');
		root.left.right = new CharNode('E');
		root.right = new CharNode('C');
		root.right.right = new CharNode('B');
		root.right.right.left = new CharNode('D');
		root.right.right.right = new CharNode('E');
		System.out.println(checkSubtree(root));
	}

	private static String checkSubtree(CharNode root) {
		// TODO Auto-generated method stub
		if(root.left == null && root.right == null)
			return String.valueOf(root.ch);
		String toPut = (root.left != null?checkSubtree(root.left):"") + 
						root.ch +
						(root.right!=null?checkSubtree(root.right):"");
		if(holdmap.contains(toPut))
			System.out.println("Contains duplicate");
		else
			holdmap.add(toPut);
		return toPut;
	}

}
