package TreesNGraphs;
public class treeFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6,7,8,9};
		treeNode root = buildBst(input,0,input.length-1);
		treeTraversals.inOrderTraversal(root);

	}

	private static treeNode buildBst(int[] input, int left, int right) {
		// TODO Auto-generated method stub
		if(left>right)
			return null;
		if(left == right)
			return new treeNode(input[left]);
		else{
			int mid = (left+right)/2;
			treeNode node = new treeNode(input[mid]);
			node.left = buildBst(input,left,mid-1);
			node.right = buildBst(input,mid+1,right);
			return node;
		}
	}

}
