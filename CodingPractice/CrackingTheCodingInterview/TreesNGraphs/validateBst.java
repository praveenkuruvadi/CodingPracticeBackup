package TreesNGraphs;

public class validateBst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(8);
		root.left = new treeNode(3,new treeNode(1),new treeNode(6,new treeNode(4),new treeNode(7)));
		root.right = new treeNode(10);
		root.right.right = new treeNode(14);
		root.right.right.left = new treeNode(13);
		treeTraversals.printLevelWise(root);
		System.out.println(validateBST(root,null,null));

	}

	private static boolean validateBST(treeNode root,Integer min, Integer max) {
		// TODO Auto-generated method stub
		if(root == null)
			return true;
		if((min!=null && root.data<=min) || (max!=null && root.data>max))
			return false;
		if(!validateBST(root.left,min,root.data)||!validateBST(root.right,root.data,max))
			return false;
		return true;
	}
}
