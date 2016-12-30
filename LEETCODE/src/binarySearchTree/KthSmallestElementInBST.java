package binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {

	public int kthSmallest(TreeNode root, int k) {
		if(root == null || k == 0) { return 0; }
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int result = 0, index = 1;
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}else {
				TreeNode node = stack.pop();
				result = node.val;
				if(index == k) {
					break;
				}
				index++;
				curr = node.right;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		

	}

}
