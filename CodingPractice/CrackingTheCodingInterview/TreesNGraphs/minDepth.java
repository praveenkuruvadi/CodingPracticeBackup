package TreesNGraphs;

public class minDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(10);
		root.left = new treeNode(5);
		root.right = new treeNode(20,new treeNode(3,new treeNode(9),new treeNode(18)),new treeNode(7));
		treeTraversals.printLevelWise(root);
		System.out.println(minDepthTree(root));

	}

	private static int minDepthTree(treeNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		else return 1+Math.min(minDepthTree(root.left), minDepthTree(root.right));
	}

}
