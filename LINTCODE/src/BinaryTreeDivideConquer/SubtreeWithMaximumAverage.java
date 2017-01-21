package BinaryTreeDivideConquer;


public class SubtreeWithMaximumAverage {

    class ResultType {
        double sum = 0;
        int size = 0;
        ResultType(double sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeNode maxSubtree;
    private double maxAverage = Integer.MIN_VALUE;

    public TreeNode findSubtree2(TreeNode root) {
        maxSubtree = root;
        subtreeHelper(root);
        return maxSubtree;
    }

    private ResultType subtreeHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = subtreeHelper(root.left);
        ResultType right = subtreeHelper(root.right);

        double currSum = left.sum + right.sum + root.val;
        int currSize = left.size + right.size + 1;
        if (currSum / currSize > maxAverage) {
            maxAverage = currSum / currSize;
            maxSubtree = root;
        }

        return new ResultType(currSum, currSize);
    }
}
