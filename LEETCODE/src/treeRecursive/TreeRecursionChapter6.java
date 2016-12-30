package treeRecursive;

public class TreeRecursionChapter6 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(14);
		TreeNode node7 = new TreeNode(4);
		TreeNode node8 = new TreeNode(7);
		TreeNode node9 = new TreeNode(13);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		
		node5.left = node7;
		node5.right = node8;
		
		node6.left = node9;
		
		TreeRecursionChapter6 tree = new TreeRecursionChapter6();
		tree.preorderTraverse(node1);
		tree.inorderTraverse(node1);
		tree.postorderTraverse(node1);
	}
	
	public void preorderTraverse(TreeNode root){
		if(root == null) { return; }
		System.out.println(root.val);
		preorderTraverse(root.left);
		preorderTraverse(root.right);
	}
	
	public void inorderTraverse(TreeNode root){
		if(root == null) { return; }
		inorderTraverse(root.left);
		System.out.println(root.val);
		inorderTraverse(root.right);
	}
	
	public void postorderTraverse(TreeNode root){
		if(root == null) { return; }
		postorderTraverse(root.left);
		postorderTraverse(root.right);
		System.out.println(root.val);
	}
	
	private int sum;
	public int getLeafSum(TreeNode root){
		sum = 0;
		helper(root);
		return sum;
	}
	public void helper(TreeNode root){
		if(root == null){return;}
		if(root.left == null && root.right == null){
			sum += root.val;
		}
		helper(root.left);
		helper(root.right);
	}
	
	private int height;
	public int getTreeHeight(TreeNode root){
		height = 0;
		heightHelper(root,1);
		return height;
	}
	private void heightHelper(TreeNode root, int depth){
		if(root == null){ return; }
		if(depth > height){ height = depth; }
		heightHelper(root.left,depth + 1);
		heightHelper(root.right,depth + 1);
	}
	
}
