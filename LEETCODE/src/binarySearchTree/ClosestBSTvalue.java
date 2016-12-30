package binarySearchTree;

public class ClosestBSTvalue {
	
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		double min = Double.MAX_VALUE;
		
		while(root != null) {
			/* 不断替换使得当前节点与target差最小 */
			if(Math.abs(root.val - target) < min) {
				min = Math.abs(root.val - target);
				closest = root.val;
			}
			/* BST Search */
			if(root.val == target) {
				return root.val;
			}else if(root.val < target) {
				root = root.right;
			}else {
				root = root.left;
			}
		}
		return closest;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4); TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8); TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3); TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(10);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node3.left = node6; node3.right = node7;
		
		ClosestBSTvalue bst = new ClosestBSTvalue();
		System.out.println(bst.closestValue(node1, 7));
		
		
		TreeNode node8 = new TreeNode(2); TreeNode node9 = new TreeNode(1);
		node8.left = node9;
		int target = Integer.MAX_VALUE;
		System.out.println(bst.closestValue(node8, target));
	}

}
