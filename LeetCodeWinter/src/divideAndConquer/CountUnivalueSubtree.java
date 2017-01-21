package divideAndConquer;


public class CountUnivalueSubtree {

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        isUnivalSubtree(root, count);
        return count[0];
    }

    public boolean isUnivalSubtree(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }
        // leftsubtree && rightsubtree are not uni, then root subtree is not uni
        // uni means all nodes in the tree has same value.
        boolean left = isUnivalSubtree(root.left, count);
        boolean right = isUnivalSubtree(root.right, count);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CountUnivalueSubtree cus = new CountUnivalueSubtree();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(cus.countUnivalSubtrees(node1));
    }

/*    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtree = countUnivalSubtrees(root.left);
        int rightSubtree = countUnivalSubtrees(root.right);
        if (root.left != null && root.right != null) {
            if (root.val == root.left.val && root.val == root.right.val) {
                return leftSubtree + rightSubtree + 1;
            } else {
                return leftSubtree + rightSubtree;
            }
        } else if (root.left != null) {
            return root.val == root.left.val? leftSubtree + 1 : leftSubtree;
        } else if (root.right != null) {
            return root.val == root.right.val? rightSubtree + 1 : rightSubtree;
        }
        return 1;
    }*/
}
