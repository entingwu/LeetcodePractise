package binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator {

	/** BinarySearchTreeIterator 
	 *  Your BSTIterator will be called like this:
	 *  BSTIterator i = new BSTIterator(root);
	 *  while (i.hasNext()) v[f()] = i.next();
	 */
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode currNode = null;
	public BinarySearchTreeIterator(TreeNode root) {
		currNode = root;
	}
	/** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty() && currNode == null);
    }

    /** @return the next smallest number */
    public int next() {
        while(currNode != null) {
        	stack.push(currNode);
        	currNode = currNode.left;
        }
        TreeNode node = stack.pop();
        currNode = node.right;
        return node.val;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null) { return result; }
		TreeNode currNode = root;
		while(!stack.isEmpty() || currNode != null) {
			if(currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;//下到最底层,null,再弹出最左节点
			}else {
				TreeNode node = stack.pop();
				result.add(node.val);
				currNode = node.right;//右子树
			}
		}
		return result;
	}
	
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
		
		BinarySearchTreeIterator bst = new BinarySearchTreeIterator(node1);
		List<Integer> res = new ArrayList<Integer>();
		res = bst.inorderTraversal(node1);
		System.out.println(res);

	}

}
