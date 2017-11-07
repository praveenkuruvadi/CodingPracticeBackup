package ArraysNStrings;

class Node{
	int data;
	Node right;
	Node down;
}

public class contructLinkedListFromMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2, 3 }, 
		                { 4, 5, 6 }, 
		               { 7, 8, 9 } };
		Node root = constructList(arr,0,0);
		Display(root);
	}
	
	public static Node constructList(int[][] matrix,int i,int j){
		if(i<matrix.length && j<matrix[0].length){
			Node node = new Node();
			node.data = matrix[i][j];
			node.right = constructList(matrix,i,j+1);
			node.down = constructList(matrix,i+1,j);
			return node;
		}else
			return null;
	}
	
	public static void Display(Node node){
		if(node == null)
			return;
		Node curr = node;
		Node down = null;
		while(curr != null){
			down = curr.down;
			while(curr != null){
				System.out.print(curr.data+"->");
				curr = curr.right;
			}
			System.out.print("Null");
			System.out.println("");
			System.out.println("|");
			curr = down;
		}
	}

}
