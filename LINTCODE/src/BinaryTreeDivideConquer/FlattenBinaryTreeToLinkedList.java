package BinaryTreeDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLast = flattenHelper(root.left);//3 4
        TreeNode rightLast = flattenHelper(root.right);//4 6

        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;// 3-4  2-3-4-5
            root.right = root.left;// 2-3-4  1-2-3-4-5-6
            root.left = null;
        }

        if (rightLast != null) {
            return rightLast;//4
        }

        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }

    private TreeNode flattenHelperI(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftSubtree = flattenHelperI(root.left);
        TreeNode rightSubtree = flattenHelperI(root.right);
        if (leftSubtree != null) {
            root.right = leftSubtree;
            root.left = null;
            if (rightSubtree != null) {
                while (leftSubtree.right != null) {
                    leftSubtree = leftSubtree.right;
                }
                leftSubtree.right = rightSubtree;
                leftSubtree.left = null;
            }
        } else {
            if (rightSubtree != null) {
                root.right = rightSubtree;
                root.left = null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fbt = new FlattenBinaryTreeToLinkedList();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        System.out.println(fbt.levelOrder(node1));
        fbt.flatten(node1);
        System.out.println(fbt.levelOrder(node1));
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
