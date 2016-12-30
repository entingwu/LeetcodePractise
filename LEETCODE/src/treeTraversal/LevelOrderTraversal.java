package treeTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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
			result.add(0,temp);//前插
		}
		//Collections.reverse(result);
		return result;
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) { return result; }
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		boolean isLeftOrder = true;
		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				//System.out.print(node.val + " " + isLeftOrder);
				if (isLeftOrder){ 
					temp.add(node.val);
				} else {
					temp.add(0, node.val);
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				
			}
			isLeftOrder = !isLeftOrder;
			result.add(temp);
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<List<Integer>> level = lot.levelOrderBottom(node1);
		System.out.println(level);
		List<List<Integer>> zigzag = lot.zigzagLevelOrder(node1);
		System.out.println(zigzag);

	}

}
