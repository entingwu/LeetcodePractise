package treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBinaryTreefromPreorderandInorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeHelper(preorder, inorder, 0, 0, inorder.length-1);
	}
	
	private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int prePos, int startIn, int endIn) {
		if(startIn > endIn) { return null; }//防溢出
		/* 1. root */
		TreeNode node = new TreeNode(preorder[prePos]);
		
		/* 2. spilt inorder[] */
		int spilt = 0;
		for(int i = startIn; i <= endIn; i++) {
			if(inorder[i] == preorder[prePos]) {
				spilt = i;
				break;
			}
		}
		/* 3. dfs */
		/* preorder[prePos+1], inorder[startIn] ~ inorder[spilt-1] */
		node.left = buildTreeHelper(preorder, inorder, prePos + 1, startIn, spilt-1);
		/* preorder[prePos + spilt - startIn + 1], inorder[spilt + 1] ~ inorder[endIn] */
		node.right = buildTreeHelper(preorder, inorder, prePos + spilt - startIn + 1, spilt + 1, endIn);
		return node;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) { return result; }
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<Integer>();
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
			result.add(new ArrayList(temp));
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] preorder = {1,2,4,5,3};
		int[] inorder = {4,2,5,1,3};
		ConstructBinaryTreefromPreorderandInorder cbt = new ConstructBinaryTreefromPreorderandInorder();
		TreeNode node = cbt.buildTree(preorder, inorder);
		List<List<Integer>> result = cbt.levelOrder(node);
		System.out.println(result);
	}

}
