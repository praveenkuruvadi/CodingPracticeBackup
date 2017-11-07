package TreesNGraphs;

public class sumBelowLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(8);
		root.left = new treeNode(3,new treeNode(1),new treeNode(6,new treeNode(4),new treeNode(7)));
		root.right = new treeNode(9);
		root.right.right = new treeNode(14);
		root.right.right.left = new treeNode(13);
		treeTraversals.printLevelWise(root);
		System.out.println(sumBeyondLevel(root,1,3));

	}

	private static int sumBeyondLevel(treeNode root, int currLevel, int level) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		return (currLevel>=level?root.data:0) + 
					sumBeyondLevel(root.left,currLevel+1,level)+ 
					sumBeyondLevel(root.right,currLevel+1,level);
	}

}
