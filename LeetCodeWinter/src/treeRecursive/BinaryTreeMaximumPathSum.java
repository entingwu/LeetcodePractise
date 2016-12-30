package treeRecursive;

public class BinaryTreeMaximumPathSum {

    class ResultType {
        int singlePathSum;
        int maxPathSum;
        public ResultType(int singlePathSum, int maxPathSum) {
            this.singlePathSum = singlePathSum;
            this.maxPathSum = maxPathSum;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);// maxPathSum = min, [-3], prevMaxPathSum == min
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // Conquer
        int singlePathSum = Math.max(Math.max(left.singlePathSum, right.singlePathSum), 0) + root.val;
        int prevMaxPathSum = Math.max(left.maxPathSum, right.maxPathSum);//prev
        int maxPathSum = Math.max(prevMaxPathSum,
                Math.max(left.singlePathSum, 0) + Math.max(right.singlePathSum, 0) + root.val);
        return new ResultType(singlePathSum, maxPathSum);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) { return 0; }
        return helper(root).maxPathSum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
        System.out.println(btmps.maxPathSum(node1));

        TreeNode node6 = new TreeNode(-3);
        System.out.println(btmps.maxPathSum(node6));
    }

/*    public int maxPathSumII(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = maxPathSumII(root.left);
        int right = maxPathSumII(root.right);
        return Math.max(Math.max(left, right), 0) + root.val;
    }*/
}
