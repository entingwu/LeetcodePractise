package BinaryTreeDivideConquer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversal(result, String.valueOf(root.val), root);
        return result;
    }

    private void traversal(List<String> result, String temp, TreeNode root) {
        if (root.left == null && root.right == null) {
            result.add(temp);
            return;
        }

        if (root.left != null) {
            traversal(result, temp + "->" + root.left.val, root.left);
        }
        if (root.right != null) {
            traversal(result, temp + "->" + root.right.val, root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        System.out.println(btp.binaryTreePaths(node1));
    }

    public List<String> binaryTreePathsI(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversalI(result, "", root);
        return result;
    }

    private void traversalI(List<String> result, String temp, TreeNode root) {
        temp = temp + root.val + "->";

        if (root.left == null && root.right == null) {
            temp = temp.substring(0, temp.length() - 2);
            result.add(temp);
            return;
        }

        if (root.left != null) {
            traversal(result, temp, root.left);
        }
        if (root.right != null) {
            traversal(result, temp, root.right);
        }
    }
}
