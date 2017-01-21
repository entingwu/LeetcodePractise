package TreeTraversal;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {// bottom
                TreeNode node = stack.pop();
                result.add(node.val);
                curr = node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;

        System.out.println(btit.levelorder(node1));
        System.out.println(btit.inorderTraversal(node1));
    }

    private List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
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
