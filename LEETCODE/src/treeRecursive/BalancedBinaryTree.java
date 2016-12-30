package treeRecursive;

public class BalancedBinaryTree {
	
	class ResultType {
		int maxDepth;
		boolean isBalanced;
		ResultType(boolean isBalanced, int maxDepth) {
			this.isBalanced = isBalanced;
			this.maxDepth = maxDepth;
		}
	}
	
	public boolean isBalanced(TreeNode root) {
		return helper(root).isBalanced;
	}
	
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, 0);
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		if (!left.isBalanced || !right.isBalanced) {
			return new ResultType(false, -1);
		}
		
		if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new ResultType(false, -1);
		}
		
		return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
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
