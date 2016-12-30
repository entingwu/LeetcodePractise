package divideConquer;

public class LowestCommonAncestor {

	/**/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/* base case */ 
		if(root == null || root == p || root == q) { return root; }
		/* 1. Devide*/
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		/* 2. Conquer */
		if(left != null && right != null) {
			return root;
		}else if(left != null) {
			return left;
		}else if(right != null) {
			return right;
		}else {
			return null;
		}
	}
	
	/* BST */
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root.val == p.val || root.val == q.val) {
			return root;
		}else if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestorBST(root.left, p, q);
		}else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestorBST(root.right, p, q);
		}else {
			return root;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		root.left = p;
		root.right = q;
		LowestCommonAncestor lca = new LowestCommonAncestor();
		System.out.println((lca.lowestCommonAncestor(root, p, q)).val);

	}

}
