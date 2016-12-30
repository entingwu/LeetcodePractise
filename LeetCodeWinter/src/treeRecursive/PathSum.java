package treeRecursive;

public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) { return 0; }
        int parentPathSum = parentToChildPathSum(root, sum);
        return parentPathSum + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int parentToChildPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int isPathSum = (sum == root.val? 1 : 0);
        return isPathSum + parentToChildPathSum(root.left, sum - root.val) + parentToChildPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        int sum = 8;

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.parentToChildPathSum(node1, sum));
        System.out.println(pathSum.pathSum(node1, sum));
    }

/*    public int pathSum(TreeNode root, int sum) {
        if (root == null) { return 0; }
        int parentPathSum = parentToChildPathSum(root, sum);
        return pathSum(root.left, sum) + pathSum(root.right, sum) + parentPathSum;
    }

    private int parentToChildPathSum(TreeNode root, int sum) {
        if (sum == root.val) {
            return 1;
        }
        if (root.left == null && root.right == null) {//叶子节点为所求值:bug
            return 0;
        }
        if (root.left == null) {
            return parentToChildPathSum(root.right, sum - root.val);
        }
        if (root.right == null) {
            return parentToChildPathSum(root.left, sum - root.val);
        }
        return parentToChildPathSum(root.left, sum - root.val) + parentToChildPathSum(root.right, sum - root.val);
    }*/
}
