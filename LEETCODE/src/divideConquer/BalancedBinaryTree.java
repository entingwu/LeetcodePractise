package divideConquer;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if(root == null) { return true; }
		if(!isBalanced(root.left)) { return false; }
		if(!isBalanced(root.right)) { return false; }
		int delta = Math.abs(getHeight(root.left) - getHeight(root.right));
		return delta <= 1;
	}
	
	private int getHeight(TreeNode node) {
		if(node == null) { return 0; }
		int left = getHeight(node.left);
		int right = getHeight(node.right);
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(node1));
		
	}

}
