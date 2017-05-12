package otherProblems;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class trieNode{
    HashMap<Character, trieNode> childMap;
    Character data;
    int count;
    boolean isLeaf;
    
    public trieNode(Character c){
        this.childMap = new HashMap<Character,trieNode>();
        this.data =c;
        this.count =0;
        this.isLeaf =Boolean.FALSE;
    }
    public trieNode(){
        this.childMap = new HashMap<Character,trieNode>();
        this.count =0;
        this.isLeaf =Boolean.FALSE;
    }
}


class trie{
	trieNode root;
	public trie(){
		this.root = new trieNode();
	}
	
	public void insertData(String word){
	  char arr[] = word.toCharArray();
	  trieNode curr = this.root;
	 // curr.count++;
	  for(int i=0;i<=arr.length;i++){
	      if(i==arr.length){
	          curr.isLeaf = Boolean.TRUE;
	          break;
	      }else{
	          if(curr.childMap.containsKey(arr[i])){
	              curr.count++;
	              curr = curr.childMap.get(arr[i]);
	          }else{
	              curr.count++;
	              curr.childMap.put(arr[i],new trieNode(arr[i]));
	              curr = curr = curr.childMap.get(arr[i]);
	          }
	      }
	  }
	}
	
  public int findPartialCount(String data){
  char arr[] = data.toCharArray();
  trieNode curr = this.root;
  if(root.count ==0)
      return 0;
      
  else{
      for(int i=0;i<arr.length;i++){
          if(!curr.childMap.containsKey(arr[i]))
              break;
          else if(i == arr.length-1)
              return curr.count;
          curr = curr.childMap.get(arr[i]);
      }
      return 0;
  }
}
}

public class triesContact {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        trie t = new trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add"))
                t.insertData(contact);
            else if(op.equals("find"))
                System.out.println(t.findPartialCount(contact));
        }
    }
}
