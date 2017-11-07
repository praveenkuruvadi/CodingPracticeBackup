package TreesNGraphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

public class verticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(1);
		root.left = new treeNode(2);
		root.right = new treeNode(3);
		root.left.left = new treeNode(4);
		root.left.right = new treeNode(5);
		root.right.left = new treeNode(6);
		root.right.right = new treeNode(7);
		root.right.left.right = new treeNode(8);
		root.right.right.right = new treeNode(9);
		verticalTraversal(root);
		topView(root);
	}
	
	private static void topView(treeNode root){
		HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
		getDistances(root,map,0);
		Integer[] keys= map.keySet().toArray(new Integer[map.keySet().size()]);
		Arrays.sort(keys);
		for(int i:keys){
			System.out.print(map.get(i).get(0)+" ");
		}
	}
	
	private static void verticalTraversal(treeNode root){
		HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
		getDistances(root,map,0);
		Integer[] keys= map.keySet().toArray(new Integer[map.keySet().size()]);
		Arrays.sort(keys);
		for(int i:keys){
			LinkedList<Integer> list = map.get(i);
			for(int j:list)
				System.out.print(j+" ");
			System.out.println("");
		}
	}

	private static void getDistances(treeNode root, HashMap<Integer, LinkedList<Integer>> map, int dist) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		if(map.containsKey(dist))
			map.get(dist).add(root.data);
		else{
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(root.data);
			map.put(dist,list);
		}
		getDistances(root.left,map,dist-1);
		getDistances(root.right,map,dist+1);
	}

}