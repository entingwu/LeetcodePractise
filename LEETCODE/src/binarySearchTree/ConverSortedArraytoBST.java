package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import treeRecursive.TreeNode;

public class ConverSortedArraytoBST {
	/* 1. Array -> BST */
	public TreeNode sortedArrayToBST(int[] nums){
		return builtArrayTree(nums, 0, nums.length-1);
	}
	private TreeNode builtArrayTree(int[] nums, int left, int right) {
		if(left > right){ return null; }
		int midIndex = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[midIndex]);
		node.left = builtArrayTree(nums, left, midIndex - 1);
		node.right = builtArrayTree(nums, midIndex + 1, right);
		return node;
	}
	
	/* 2. LinkedList -> BST */
	private ListNode current;
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) { return null; }
		current = head;
		int count = 0;
		
		while(head != null){ 
			head = head.next; 
			count++;
		}
		System.out.println(count);
		return builtListTree(0, count - 1);
	}
	
	private TreeNode builtListTree(int start, int end) {
		if(start > end) { return null; }
		int mid = start + (end - start) / 2;
		// left
		TreeNode left = builtListTree(start, mid-1);
		// middle
		TreeNode node = new TreeNode(current.val);
		node.left = left;
		current = current.next;
		// right
		node.right = builtListTree(mid + 1, end);
		return node;
	}
	
	/*private TreeNode builtListTree1(ListNode head, int start, int end) {
		if(start > end) { return null; }
		int mid = start + (end - start) / 2;
		int nodeIndex = mid;
		ListNode parent = head;
		while(mid >= 0){
			parent = parent.next;
			mid--;
		}
		TreeNode node = new TreeNode(parent.val);
		node.left = builtListTree(parent, start, nodeIndex - 1);
		node.right = builtListTree(parent.next, nodeIndex + 1, end);
		return node;
	}*/
	
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){ return result; }
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
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
		int[] nums = {1,2,3,4,5,6,7};
		ConverSortedArraytoBST csa = new ConverSortedArraytoBST();
		TreeNode newArrayTree = csa.sortedArrayToBST(nums);
		System.out.println(csa.levelOrder(newArrayTree));
		
		ConverSortedArraytoBST csa1 = new ConverSortedArraytoBST();
		ListNode node1 = new ListNode(1); ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3); ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5); ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next = node2; node2.next = node3;
		node3.next = node4; node4.next = node5;
		node5.next = node6; node6.next = node7;
		
		TreeNode newListTree = csa1.sortedListToBST(node1);
		System.out.println(csa.levelOrder(newListTree));
	}
}
