package leetCodeEasy;

public class sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.right == null && root.left == null))
            return 0;
        else if(root.left == null && root.right != null)
            return sumOfLeftLeaves(root.right);
        else if(root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left)+ sumOfLeftLeaves(root.right);
    }

}
