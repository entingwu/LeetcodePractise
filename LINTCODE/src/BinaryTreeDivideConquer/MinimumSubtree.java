package BinaryTreeDivideConquer;


public class MinimumSubtree {

    private int minValue = Integer.MAX_VALUE;
    private TreeNode minSubtree;

    public TreeNode findSubtree(TreeNode root) {
        minSubtree = root;
        subtreeHelper(root);
        return minSubtree;
    }

    private int subtreeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = subtreeHelper(root.left);
        int rightValue = subtreeHelper(root.right);
        int currentValue = root.val + leftValue + rightValue;
        if (currentValue < minValue) {
            minSubtree = root;
            minValue = currentValue;
        }
        return currentValue;
    }

    public static void main(String[] args) {
        MinimumSubtree ms = new MinimumSubtree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(-4);
        TreeNode node7 = new TreeNode(-5);
        node1.left = node2;
        node1.right = node2;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(ms.findSubtree(node1).val);
    }
}
