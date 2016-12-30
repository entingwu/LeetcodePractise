package treeRecursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {
	/* 1. NEW TREE INVERT*/
	public TreeNode invertTree1(TreeNode root) {
        if(root == null) { return null; }
        TreeNode newTree = new TreeNode(root.val);
        if(root.left != null){
        	newTree.right  = invertTree1(root.left);
        }
        if(root.right != null){
        	newTree.left  = invertTree1(root.right);
        }
        return newTree;
    }
	
	/* 2. ORIGINAL TREE INVERT*/
	public void invertTree(TreeNode root) {
		if(root == null) { return; }
		//swap(root.left, root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
	}
	private void swap(TreeNode node1, TreeNode node2) {//node1与root没关系,root被丢失了
		TreeNode temp = node1;
		node1 = node2;
		node2 = temp;
	}
	
	public List<List<Integer>> levelOrderTraversal(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) { return result; }
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i< size; i++){
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			result.add(temp);
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(9);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		InvertBinaryTree ibt = new InvertBinaryTree();
		List<List<Integer>> result1 = ibt.levelOrderTraversal(node1);
		System.out.println(result1);
		
		TreeNode newRoot = ibt.invertTree1(node1);
		List<List<Integer>> result2 = ibt.levelOrderTraversal(newRoot);
		System.out.println(result2);
		
		ibt.invertTree(node1);
		List<List<Integer>> result3 = ibt.levelOrderTraversal(node1);
		System.out.println(result3);
		
		TreeNode newNode1 = node1.left;
		newNode1.val = 100;
		System.out.println(node1.left.val);
		
		
	}

}
