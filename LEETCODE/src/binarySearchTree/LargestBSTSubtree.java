package binarySearchTree;

import treeRecursive.TreeNode;

/*
 * Given a binary tree, find the largest Binary Search Tree (BST),
 * where largest means BST with largest number of nodes in it.
 * The largest BST may or may not include all of its descendants.
 * */
public class LargestBSTSubtree {
	
	public int largestBSTSubtree(TreeNode root) {
		/* base case */
		if(root == null) { return 0;}
		if (root.left == null && root.right == null){ return 1; }
		if(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return countNode(root);
		}
		return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
	
	private boolean isValidBST(TreeNode root, int min, int max) {
		if(root == null) { return true; }
		if(min > root.val || root.val > max) { return false; }
		return isValidBST(root.left, min, root.val) 
				&& isValidBST(root.right, root.val, max);
	}
	
	private int countNode(TreeNode root) {
		if(root == null) { return 0; }
		return countNode(root.left) + countNode(root.right) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		
		LargestBSTSubtree lbst = new LargestBSTSubtree();
		System.out.println(lbst.largestBSTSubtree(node1));

	}

}
