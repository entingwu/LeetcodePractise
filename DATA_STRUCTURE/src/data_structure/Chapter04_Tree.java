package data_structure;

/* Chapter04 Tree and Graph */

class TreeNode{
	public String name;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(){
		left = null;
		right = null;
	}
}
class Tree1{
	public Node root;
	public Tree1(){
		root = null;
	}
	
	public void inOrderTraversal(TreeNode node){
		if(node != null){
			inOrderTraversal(node.left);
			System.out.print(node.name + " ");
			inOrderTraversal(node.right);
		}
	}
	
	public void preOrderTraversal(TreeNode node){
		if(node != null){
			System.out.print(node.name + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal(TreeNode node){
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.name + " ");
		}
	}
}

public class Chapter04_Tree {

	public static void main(String[] args) {
		

	}

}
