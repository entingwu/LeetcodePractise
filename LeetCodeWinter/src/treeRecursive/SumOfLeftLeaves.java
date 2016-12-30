package treeRecursive;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currLeftLeave = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            currLeftLeave = root.left.val;
        }
        return currLeftLeave + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        SumOfLeftLeaves sum = new SumOfLeftLeaves();
        System.out.println(sum.sumOfLeftLeaves(node1));
    }

}
