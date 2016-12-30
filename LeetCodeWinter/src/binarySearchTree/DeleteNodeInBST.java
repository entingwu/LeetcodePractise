package binarySearchTree;

import java.util.List;

public class DeleteNodeInBST extends BinarySearchTree {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) { //left
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) { //right
            root.right = deleteNode(root.right, key);
        } else {
            TreeNode t = root;
            if (t.left == null) {
                return t.right;
            }
            if (t.right == null) {
                return t.left;
            }
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    private TreeNode min(TreeNode x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    private TreeNode deleteMin(TreeNode x) {
        if (x.left == null) {// x is min
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        int key = 3;

        DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();
        TreeNode root = deleteNodeInBST.deleteNode(node1, key);
        List<List<Integer>> result = deleteNodeInBST.levelOrder(root);
        System.out.println(result);
    }
}