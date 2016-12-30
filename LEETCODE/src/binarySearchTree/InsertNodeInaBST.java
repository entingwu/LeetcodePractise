package binarySearchTree;

public class InsertNodeInaBST {
	
	public boolean isIdentical(TreeNode a, TreeNode b) {
		if(a == null && b == null) { 
			return true; 
		} else if(a == null || b == null) { 
			return false; 
		}
		if(a.val != b.val) { 
			return false; 
		} else { 
			return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
		}
	}
	
	public TreeNode insertNode(TreeNode node, TreeNode insert){
		if(node == null){
			return new TreeNode(insert.val);
		}
		if(node.val > insert.val){
			node.left = insertNode(node.left, insert);
		}
		if(node.val < insert.val){
			node.right = insertNode(node.right, insert);
		}
		return node;
	}
	
	public static void main(String[] args) {
		

	}

}
