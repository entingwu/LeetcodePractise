package BinaryTreeDivideConquer;


public class ValidateBinarySearchTree {

    private int preValue = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBSTI(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBSTI(root.left)) {
            return false;
        }
        if (!firstNode && preValue >= root.val) {
            return false;
        }
        firstNode = false;
        preValue = root.val;
        if (!isValidBSTI(root.right)) {
            return false;
        }
        return true;
    }

    /** Divide & Conquer */
    public boolean isValidBST(TreeNode root) {
        return validBSThelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBSThelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return validBSThelper(root.left, min, root.val) && validBSThelper(root.right, root.val, max);
    }

/*    public boolean validBSThelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        boolean isLeftValidBST = validBSThelper(root.left, min, root.val);
        boolean isRightValidBST = validBSThelper(root.right, root.val, max);

        if (root.val >= max || root.val <= min) {
            return false;
        }

        if (!isLeftValidBST || !isRightValidBST) {
            return false;
        }

        if (root.left != null && root.val <= root.left.val) {//{1, 1}
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        return true;
    }*/

    public static void main(String[] args) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        System.out.println(vbst.isValidBST(node1));
        System.out.println(vbst.isValidBST(new TreeNode(-2147483648)));
    }
}
