package binarySearchTree;

class BST {
	private TreeNode root;
	
	/* 1. SERACH */
	public boolean contains(int target) {
		return searchHelper(root,target);//root不可见
	}
	private boolean searchHelper(TreeNode root, int target) {
		if(root == null) {
			return false; 
		}
		if(target == root.val) { 
			return true; 
		} else if (target < root.val ) {
			return searchHelper(root.left, target);
		} else {
			return searchHelper(root.right, target);
		}
		
	}
	
	/* 2. INSERT */
	
	public void insert(int val) {
		root = insertHelper(root, val);
	}
	
	private TreeNode insertHelper(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}
		if(val < root.val) {
			root.left = insertHelper(root.left, val);
		} else {
			root.right = insertHelper(root.right, val);
		}
		return root;
	}
	
	public void inorderTraversal() {
		inorderTraversalHelper(root);
	}
	private void inorderTraversalHelper(TreeNode root) {
		if(root == null) { return; }
		inorderTraversalHelper(root.left);
		System.out.print(root.val + " ");
		inorderTraversalHelper(root.right);
	}
}

public class BSThashtable7 {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(4);
		bst.insert(10);
		bst.insert(14);
		bst.insert(13);
		bst.inorderTraversal();
		
		System.out.println(bst.contains(8));
	}
}
