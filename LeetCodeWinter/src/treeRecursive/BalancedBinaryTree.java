package treeRecursive;


public class BalancedBinaryTree {

    /** Result Type */
    class ResultType {
        boolean isBalanced;
        int maxDepth;
        ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }

    public boolean isBalancedI(TreeNode root) {
        return balancedHelper(root).isBalanced;
    }

    private ResultType balancedHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = balancedHelper(root.left);
        ResultType right = balancedHelper(root.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }

    /** Without Result Type */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int left = root.left != null ? treeHeight(root.left) : 0;
        int right = root.right != null ? treeHeight(root.right) : 0;
        return Math.abs(left - right) <= 1;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(bbt.isBalancedI(node1));
    }
}
