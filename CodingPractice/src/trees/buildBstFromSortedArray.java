package trees;

public class buildBstFromSortedArray {

	private static final int[] sortedArray= {1,2,3,4,5,6,7,8};
	
	public static void main(String[] args) {
		treeNode root = buildBst(sortedArray,0,sortedArray.length-1);
		tree t = new tree(root);
		System.out.println("Root: "+t.getRoot().getData());
		System.out.println("Height: "+t.getHeight());
		System.out.println("-----------");
		t.inorderTraversal(root);

	}
	
	private static treeNode buildBst(int[] arr,int i,int j){
		if(i>j)
			return null;
		if(i==j)
			return new treeNode(arr[i]);
		int mid = (i+j)/2;
		return new treeNode(arr[mid],buildBst(arr,i,mid-1),buildBst(arr,mid+1,j));
	}

}
