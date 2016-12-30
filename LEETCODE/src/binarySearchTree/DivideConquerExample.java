package binarySearchTree;

public class DivideConquerExample {
	/*WAY 1*/
	public boolean isBalanced1(TreeNode root) {
		return !(isBalancedHelper(root) == -1);
	}
	private int isBalancedHelper(TreeNode root) {
		if(root == null) { return 0; }
		int leftHeight = isBalancedHelper(root.left);
		int rightHeight = isBalancedHelper(root.right);
		if(leftHeight == -1 || rightHeight == -1) { return -1; }
		if(Math.abs(leftHeight - rightHeight) >= 1) { return -1; }
		else { return Math.max(leftHeight, rightHeight) + 1; }
	}
	/*WAY 2*/
	public boolean isBalanced(TreeNode root) {
		if(root == null) { return true; }
		if(!isBalanced(root.left)) { return false; }
		if(!isBalanced(root.right)) { return false; }
		int delta = getHeight(root.left) - getHeight(root.right);
		return delta >= -1 && delta <= 1;
	}
	private int getHeight(TreeNode node) {
		if(node == null) { return 0; }
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	
	/*public boolean isIdentical(TreeNode root1, TreeNode root2) {
		
	}*/
	
	public static void main(String[] args) {
		

	}

}
