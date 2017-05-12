package leetCodeEasy;

public class checkBalancedTree {
	public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        else if(Math.abs(depth(root.right)-depth(root.left))>1)
            return false;
        else
            return isBalanced(root.right) && isBalanced(root.left);
        
    }
    
    public int depth(TreeNode root){
        if(root == null)
            return 0;
        if(root.left != null && root.right == null)
            return 1+ depth(root.left);
        else if(root.right != null && root.left == null)
            return 1+depth(root.right);
        else{
            return 1+Math.max(depth(root.left),depth(root.right));
        }
            
    }

}
