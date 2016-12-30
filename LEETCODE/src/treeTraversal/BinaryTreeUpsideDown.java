package treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUpsideDown {
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		/* 1. base case */
		if(root == null) { return null; }
		if(root.left == null) { return root; }
		
		/* 2. save */
		TreeNode leftChild = root.left;
		TreeNode rightChild = root.right;
		
		/* 3. recursive */
		TreeNode newHead = upsideDownBinaryTree(leftChild);
		
		/* 4. operation */
		leftChild.left = rightChild;
		leftChild.right = root;
		root.left = null;
		root.right = null;
		
		/* 5. return */
		return newHead;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		BinaryTreeUpsideDown bt = new BinaryTreeUpsideDown();
		TreeNode root =  bt.upsideDownBinaryTree(node1);
		List<List<Integer>> result = bt.levelOrderBottom(root);
		System.out.println(result);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) { return result; }
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
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
