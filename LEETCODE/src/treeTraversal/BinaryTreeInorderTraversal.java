package treeTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                TreeNode curr = stack.pop();
                result.add(curr.val);
                node = curr.right;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		

	}

}
