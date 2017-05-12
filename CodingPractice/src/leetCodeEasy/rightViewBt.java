package leetCodeEasy;

import java.util.ArrayList;
import java.util.List;


public class rightViewBt {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> outList = new ArrayList<Integer>();
        if (root == null)
            return outList;
        rightview(root,0,outList);
        return outList;
        
    }
    
    public void rightview(TreeNode root,int depth,List<Integer> outList){
        if(root == null)
            return;
        if(depth == outList.size())
            outList.add(root.val);
        rightview(root.right,depth+1,outList);
        rightview(root.left,depth+1,outList);
    }

}
