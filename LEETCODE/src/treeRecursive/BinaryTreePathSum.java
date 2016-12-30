package treeRecursive;

import java.util.*;

public class BinaryTreePathSum {
	/* 1. Path Sum */
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(root == null){ return null; }
		int sum = 0;
		pathSumHelper(result,temp,root,target,sum);
		return result;
	}
	
	private void pathSumHelper(List<List<Integer>> result,List<Integer> temp, TreeNode root, int target, int sum){
		sum += root.val;//重复步骤放前面
		temp.add(root.val);
		if(root.left == null && root.right == null){
			if(sum == target){
				result.add(new ArrayList(temp));//不要add引用，而是add引用对应的实际值
				return;
			}
		}
		if(root.left != null) {
			pathSumHelper(result,temp,root.left,target,sum);
		}
		if(root.right !=null) {
			pathSumHelper(result,temp,root.right,target,sum);
		}
		temp.remove(temp.size() -1);//回弹前删除当前节点值
	}
	
	/* 2. Paths */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		String temp = "";
		if(root == null){ return result; }
		findPathsHelper(result, temp, root);
		return result;
	}
	private void findPathsHelper(List<String> result, String temp, TreeNode node){
		String curStr = "";
		curStr = temp + String.valueOf(node.val) + "->";
		if(node.left == null && node.right == null){
			result.add(curStr.substring(0,curStr.length()-2));
			return;
		}
		if(node.left != null){
			findPathsHelper(result,curStr,node.left);
		}
		if(node.right != null){
			findPathsHelper(result,curStr,node.right);
		}
		//temp = temp.substring(0, temp.length()-1);
	}
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		//node2.left = node4;
		node2.right = node5;
		
		/* 1. Path Sum */
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		BinaryTreePathSum btps = new BinaryTreePathSum();
		result = btps.binaryTreePathSum(node1,5);
		System.out.println(result);
		
		/* 2. Paths */
		BinaryTreePathSum btps1 = new BinaryTreePathSum();
		List<String> result1 = btps1.binaryTreePaths(node1);
		System.out.println(result1); 
	}
	
	
	private void pathSumHelper1(List<List<Integer>> result,List<Integer> temp, TreeNode root, int target, int sum){
		if(root.left == null && root.right == null){
			sum += root.val;
			temp.add(root.val);
			if(sum == target){
				result.add(new ArrayList(temp));
				temp.remove(temp.size() -1);
			}else{
				temp.remove(temp.size() -1);
				return;
			}
		}else{
			sum += root.val;
			temp.add(root.val);
			if(root.left != null) {
				pathSumHelper(result,temp,root.left,target,sum);
			}
			if(root.right !=null) {
				pathSumHelper(result,temp,root.right,target,sum);
			}
			temp.remove(temp.size() -1);
		}
	}
}
