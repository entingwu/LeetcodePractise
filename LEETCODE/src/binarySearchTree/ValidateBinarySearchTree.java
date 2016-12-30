package binarySearchTree;

import treeRecursive.TreeNode;

public class ValidateBinarySearchTree {
	/* version1 */
	private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;//处理只有一个node
	public boolean isValidBST(TreeNode root) {
		if(root == null) { return true; }
		/* 1. left */
		if(!isValidBST(root.left)) { 
			return false; 
		}
		
		/* 2. middle 
    	 *    Traverse the tree in inorder fashion and keep a track of previous node. Allows only distinct valued nodes */
		if(!firstNode && lastVal >= root.val){ //防止Integer.MIN_VALUE>=root.val == -2147483648的corner case
			return false; 
		}
		firstNode = false;//第二次出现
		lastVal = root.val;
		
		/* 3. right */
		if(!isValidBST(root.right)) { 
			return false; 
		}
		return true;
	}
	
	/* version2 : Divide and Conquer */
	public boolean isValidBSTree(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isValidBSTHelper(TreeNode node, int min, int max){
		if(node == null) { return true; }
		if(min > node.val || node.val > max) { return false; }
		return isValidBSTHelper(node.left, min, node.val-1) 
				&& isValidBSTHelper(node.right, node.val+1, max);
	}
	
	/* version3 : Divide and Conquer */
	class ResultType {
		boolean isBst;
		int maxValue;
		int minValue;
		public ResultType(boolean isBst, int maxValue, int minValue) {
			this.isBst = isBst;
			this.maxValue = maxValue;
			this.minValue = minValue;
		}
	}
	
	public boolean isValidBST1(TreeNode root) {
		ResultType r = validateHelper(root);
		return r.isBst;
	}
	
	private ResultType validateHelper(TreeNode root) {
		if(root == null) { 
			return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE); 
		}
		//1. divide
		ResultType left = validateHelper(root.left);
		ResultType right = validateHelper(root.right);
		
		//2. conquer
		if(!left.isBst || !right.isBst) {
			return new ResultType(false, 0, 0);
		}
		if(root.left!=null && left.maxValue >= root.val || root.right!=null && root.val >= right.minValue) {//left,right
			return new ResultType(false, 0, 0);
		}
		
		return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(9);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		System.out.println(vbst.isValidBST(node1));

	}

}
