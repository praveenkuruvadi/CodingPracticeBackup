package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class PathInBinaryTree {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> outList = new ArrayList<String>();
        if(root == null)
            return outList;
        Traverse(root,outList,"");
        return outList;
        
        
    }
    
    public void Traverse(TreeNode root, List<String> outList, String path){
        if(root.left == null && root.right == null){
            outList.add(path+root.val);
        }
        if(root.left !=null)
            Traverse(root.left,outList,path+root.val+"->");
        if(root.right !=null)
            Traverse(root.right,outList,path+root.val+"->");
    }

}
