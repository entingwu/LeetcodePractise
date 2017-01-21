package divideAndConquer;


public class BinaryTreeLongestConsecutiveSequence {

    private int longest = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int localLongest = 1;// at least we have root
        int leftLongestSeq = helper(root.left);
        int rightLongestSeq = helper(root.right);

        if (root.left != null && root.val + 1 == root.left.val) {
            localLongest = Math.max(leftLongestSeq + 1, localLongest);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            localLongest =  Math.max(rightLongestSeq + 1, localLongest);
        }
        longest = Math.max(longest, localLongest);
        return localLongest;
    }

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequence btl = new BinaryTreeLongestConsecutiveSequence();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;
        System.out.println(btl.longestConsecutive(node1));
    }
}
