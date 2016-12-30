package treeTraversal;

import java.util.*;

import binarySearchTree.TreeNode;

class Tree{
	private TreeNode root;
	public Tree(){
		root = null;
	}
}
public class preOrderTraversal {

	/* Binary Tree Preorder Traversal 中左右*/
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();//结果集
		Stack<TreeNode> stk = new Stack<TreeNode>();//存放中途值
		if(root == null){return res;}
		stk.push(root);
		while(!stk.isEmpty()){
			TreeNode node = stk.pop();//中
			res.add(node.val);
			if(node.right!=null){
				stk.push(node.right);//右
			}
			if(node.left!=null){
				stk.push(node.left);//左
			}	
		}
		return res;
	}
	
	/* Binary Tree Inorder Traversal 左中右*/
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){ return res; }
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;//根节点
		while(!stack.isEmpty() || currentNode != null){
			/* 1. 把左子树左孩子存到stack */
			if(currentNode != null){
				stack.push(currentNode);
				currentNode = currentNode.left;//下到最左
			}else{
				/* 2. 一边把自底向上弹出的左孩子存到res，一边指向弹出左孩子的右孩子 */
				TreeNode node = stack.pop();//左
				res.add(node.val);//中
				currentNode = node.right;//右
			}
		}
		return res;
	}
	/* Binary Tree Postorder Traversal 左右中*/
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){ return res; }
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prevPop = null;
		while(!stack.isEmpty()){
			TreeNode topNode = stack.peek();
			if((topNode.left == null && topNode.right == null) || 
			   (topNode.left != null && topNode.left.equals(prevPop)) || 
			   (topNode.right!= null && topNode.right.equals(prevPop))){//中
				/* 处理到底了||该节点左孩子或右孩子被遍历过，pop出 */
				stack.pop();
				res.add(topNode.val);
				prevPop = topNode;
				continue;
			}
			if(topNode.right != null){//右
				stack.push(topNode.right);
			}
			if(topNode.left != null){//左
				stack.push(topNode.left);
			}
		}
		return res;
	}
		
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();	
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		if(root==null){return res;}
		while(!que.isEmpty()){
			List<Integer> temp = new ArrayList<Integer>();
			int size = que.size();
			for(int i=0; i<size ;i++){
				TreeNode node = que.poll();
				temp.add(node.val);
				if(node.left!=null){
					que.add(node.left);
				}
				if(node.right!=null){
					que.add(node.right);
				}
			}
			res.add(temp);
		}
		return res;
	}
	
	//public List<List<Integer>> levelOrderBottom(TreeNode root) {}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		preOrderTraversal pot = new preOrderTraversal();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = pot.levelOrder(node1);
		System.out.println(res);
	}
}
