package TreesNGraphs;

public class pathsWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(8);
		root.left = new treeNode(3,new treeNode(1),new treeNode(6,new treeNode(4),new treeNode(7)));
		root.right = new treeNode(9);
		root.right.right = new treeNode(14);
		root.right.right.left = new treeNode(13);
		int inputSum = 17;
		System.out.println(numberPathsWithSumBruteForce(root,inputSum));
		System.out.println(numberPathsWithSumEfficient(root,inputSum));

	}

	private static int numberPathsWithSumEfficient(treeNode root, int sum) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int numberPathsWithSumBruteForce(treeNode root, int sum) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		return countFromNode(root,sum,0)+
				numberPathsWithSumBruteForce(root.left,sum)+
				numberPathsWithSumBruteForce(root.right,sum);
	}

	private static int countFromNode(treeNode root, int sum,int currSum) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		currSum+=root.data;
		return (currSum==sum?1:0)+countFromNode(root.left,sum,currSum)+countFromNode(root.right,sum,currSum);
	}

}
