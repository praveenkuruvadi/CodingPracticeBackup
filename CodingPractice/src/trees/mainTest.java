package trees;

import java.util.HashMap;
import java.util.List;

public class mainTest {

	public static void main(String[] args) {
		treeNode root = new treeNode(4);
		tree treeTest = new tree(root);
		
		treeTest.add(root, 2);
		treeTest.add(root, 6);
		treeTest.add(root, 1);
		treeTest.add(root, 3);
		treeTest.add(root, 7);
		treeTest.add(root, 5);
		System.out.println("Height:"+treeTest.getHeight());
//		System.out.println("------------");
//		System.out.println(treeTest.getRoot().getData());
//		
//		System.out.println("------------");
		
		treeTest.inorderTraversal(root);
		System.out.println("------------");
		treeTest.bfs(root);
		System.out.println("------------");
		treeTest.spinalOrder(root);
	}
}
