package treeRecursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenBinaryTreetoLinkedList {
	private TreeNode lastNode = null;
	public void flatten(TreeNode root) {
		if(root == null) { return; }
		
		if(lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root;
		
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		
		FlattenBinaryTreetoLinkedList fbt = new FlattenBinaryTreetoLinkedList();
		List<List<Integer>> tree = fbt.levelOrder(node1);
		System.out.println(tree);
		
		fbt.flatten(node1);
		tree = fbt.levelOrder(node1);
		System.out.println(tree);
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) { return result; }
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(temp);
		}
		return result;
	}
}
