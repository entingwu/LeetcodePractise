package treeRecursive;

public class MinMaxDepthofBinaryTree {

	public static int minDepth(TreeNode root) {
	    if(root == null) { return 0;}//分两个函数写，是因为当只有一个root时，depth为0
        return getMin(root);
	}
	private static int getMin(TreeNode root) {
	    if(root == null) { return Integer.MAX_VALUE; }//当有多个节点时，root即为单亲叶子节点，为最大值
	    if(root.left == null && root.right == null) { return 1; }
	    return Math.min(getMin(root.left), getMin(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		int minDepth = minDepth(node1);
		System.out.println(minDepth);
	}

}
