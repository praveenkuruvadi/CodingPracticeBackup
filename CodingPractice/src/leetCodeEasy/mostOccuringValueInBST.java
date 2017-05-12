package leetCodeEasy;

import java.util.ArrayList;
import java.util.HashMap;

public class mostOccuringValueInBST {
    private HashMap<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
         map = new HashMap<Integer,Integer>();
         ArrayList<Integer> list = new ArrayList<Integer>();
         Traverse(root);
         int max =0;
         for(int key: map.keySet()){
             if(map.get(key)>max){
                 max=map.get(key);
             }
         }
         for(int key: map.keySet()){
             if(map.get(key)==max)
                list.add(key);
         }
         int[] out = new int[list.size()];
         for(int i=0;i<list.size();i++)
            out[i]=list.get(i);
         return out;
    }
    
    public void Traverse(TreeNode root){
        if(root == null)
            return;
        else if(map.containsKey(root.val)){
            int val = map.get(root.val);
            map.put(root.val,val+1);
        }else
            map.put(root.val,1);
        
        Traverse(root.right);
        Traverse(root.left);
    }

}
