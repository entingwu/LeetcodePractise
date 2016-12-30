package treeRecursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelSum {
	private int levelSum = 0;
	public int levelSum(TreeNode root, int level) {
        if(root == null){ return 0; }
        levelSumHelper(root, level, 1);
        return levelSum;
    }
	private void levelSumHelper(TreeNode node, int targetLevel, int depth){
		if(depth == targetLevel){
			levelSum += node.val;
			return;
		}
		if(node.left != null){
			levelSumHelper(node.left, targetLevel, depth+1);
		}
		if(node.right != null){
			levelSumHelper(node.right, targetLevel, depth+1);
		}
	}
	
	private int leafSum = 0;
	public int leafSum(TreeNode root) {
		if(root == null){ return 0;}
        leafSumHelper(root);
        return leafSum;
    }
	private void leafSumHelper(TreeNode node){
		if(node.left == null && node.right == null) {
			leafSum += node.val;
 		}
		if(node.left != null) { leafSumHelper(node.left); }
		if(node.right != null) { leafSumHelper(node.right); }
	} 
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		//TreeNode node8 = new TreeNode(8);
		//TreeNode node9 = new TreeNode(9);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		//node5.left = node8;
		//node7.right = node9;
		
		BinaryTreeLevelSum btls = new BinaryTreeLevelSum();
		int levelSum = btls.levelSum(node1, 3);
		System.out.println(levelSum);
	}
	public int levelSum1(TreeNode root, int level) {	
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int levelSum = 0, curLevel = 0;
		if(root == null) { return 0; }
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i < queue.size(); i++){
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			curLevel++;
			levelSum = 0;
			if(curLevel == level){
				for(int i = 0; i < temp.size(); i++){
					levelSum += temp.get(i);
				}
				break;
			}
		}
		return levelSum;
	}
}
