package BinaryTreeDivideConquer;

public class LowestCommonAncestor {
    class ResultType {
        TreeNode ancestor;
        boolean a_exist;
        boolean b_exist;
        ResultType(TreeNode ancestor, boolean a_exist, boolean b_exist) {
            this.ancestor = ancestor;
            this.a_exist = a_exist;
            this.b_exist = b_exist;
        }
    }

    /** III. Binary Tree */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = helper(root, A, B);
        return result.a_exist && result.b_exist? result.ancestor : null;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(null, false, false);
        }
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean a_exist = root == A || left.a_exist || right.a_exist;
        boolean b_exist = root == B || left.b_exist || right.b_exist;

        if (root == A || root == B) {
            return new ResultType(root, a_exist, b_exist);
        }

        if (left.ancestor != null && right.ancestor != null) {
            return new ResultType(root, a_exist, b_exist);
        } else if (left.ancestor != null) {
            return new ResultType(left.ancestor, a_exist, b_exist);
        } else if (right.ancestor != null) {
            return new ResultType(right.ancestor, a_exist, b_exist);
        } else {
            return new ResultType(null, a_exist, b_exist);
        }
    }

    /** II. Binary Tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

    /** I. Binary Search Tree O(n)
     * 如果根节点的值大于p和q之间的较大值，说明p和q都在左子树中，那么此时我们就进入根节点的左子节点继续递归，
     * 如果根节点小于p和q之间的较小值，说明p和q都在右子树中，那么此时我们就进入根节点的右子节点继续递归，
     * 如果都不是，则说明当前根节点就是最小共同父节点，直接返回即可*/
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {// left subtree
            return lowestCommonAncestorI(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {// right subtree
            return lowestCommonAncestorI(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(lca.lowestCommonAncestor3(node1, node4, node5).val);
    }
}
