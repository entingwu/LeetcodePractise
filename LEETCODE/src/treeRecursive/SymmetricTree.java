package treeRecursive;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) { return true; }
		return checkSymmetric(root.left, root.right);
	}
	private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}else if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.val != root2.val) {
			return false;
		}else {
			return checkSymmetric(root1.left, root2.right) && checkSymmetric(root1.right, root2.left);
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		SymmetricTree st = new SymmetricTree();
		System.out.println(st.isSymmetric(node1));
	}

}
