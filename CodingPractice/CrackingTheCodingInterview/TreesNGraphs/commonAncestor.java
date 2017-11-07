package TreesNGraphs;

public class commonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(8);
		root.left = new treeNode(3,new treeNode(1),new treeNode(6,new treeNode(4),new treeNode(7)));
		root.right = new treeNode(10);
		root.right.right = new treeNode(14);
		root.right.right.left = new treeNode(13);
		treeTraversals.printLevelWise(root);
		System.out.println(commonAncestorBst(root,6,1).data);
		System.out.println(commonAncestorTree(root,6,1).data);

	}

	private static treeNode commonAncestorTree(treeNode root, int i, int j) {
		// TODO Auto-generated method stub
		if(root == null || root.data == i || root.data == j)
			return root;
		boolean lefti = isPresent(root.left,i);
		boolean leftj= isPresent(root.left,j);
		if(lefti&& leftj)
			return commonAncestorTree(root.left,i,j);
		else if(!lefti&&!leftj)
			return commonAncestorTree(root.right,i,j);
		return root;
	}

	private static boolean isPresent(treeNode root, int i) {
		// TODO Auto-generated method stub
		if(root == null)
			return false;
		if(root.data == i)
			return true;
		return isPresent(root.left,i)||isPresent(root.right,i);
	}

	private static treeNode commonAncestorBst(treeNode root, int i, int j) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		if(root.data>i && root.data >j)
			return commonAncestorBst(root.left,i,j);
		if(root.data<i && root.data <j)
			return commonAncestorBst(root.right,i,j);
		
		return root;
	}

}
