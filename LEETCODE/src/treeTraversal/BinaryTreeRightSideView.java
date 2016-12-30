package treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) { return result; }
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(i == size - 1) {
					result.add(node.val);
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.right = node5;
		
		BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
		List<Integer> result =  bt.rightSideView(node1);
		System.out.println(result);
	}

}
