package treeRecursive;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { return result; }
        while(root != null) {
            List<Integer> temp = new ArrayList<>();
            root = removeLeaves(temp, root);
            result.add(new ArrayList<>(temp));
        }
        return result;
    }

    private TreeNode removeLeaves(List<Integer> temp, TreeNode root) {
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            return null;
        }
        if (root.left != null) {
            root.left = removeLeaves(temp, root.left);
        }
        if (root.right != null) {
            root.right = removeLeaves(temp, root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree flbt = new FindLeavesOfBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(flbt.findLeaves(node1));
    }
}
