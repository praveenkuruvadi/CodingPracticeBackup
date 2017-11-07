package TreesNGraphs;

public class checkBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(10);
		root.left = new treeNode(5);
		root.right = new treeNode(20,new treeNode(3,new treeNode(9),new treeNode(18)),new treeNode(7));
		System.out.println(isBalanced(root));
		System.out.println(isBalancedEfficient(root));

	}

	private static int isBalancedEfficient(treeNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		int left = isBalancedEfficient(root.left);
		int right  = isBalancedEfficient(root.right);
		if(left == Integer.MIN_VALUE || right == Integer.MIN_VALUE || Math.abs(left-right)>1)
			return Integer.MIN_VALUE;
		else
			return 1+ Math.max(left,right);
	}

	private static boolean isBalanced(treeNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return true;
		else{
			return (Math.abs(height(root.left)-height(root.right))>1?false:true)
					&& isBalanced(root.left)
					&& isBalanced(root.right);
			
		}
	}
	
	private static int height(treeNode root){
		if(root == null)
			return 0;
		else return 1+Math.max(height(root.left), height(root.right));
	}

}
