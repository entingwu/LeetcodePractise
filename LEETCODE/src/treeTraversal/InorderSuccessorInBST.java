package treeTraversal;

import java.util.Stack;

public class InorderSuccessorInBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null || p == null) { return null; }
		if(p == root) { return p.right; }//根节点为p
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currNode = root;
		while(!stack.isEmpty() || currNode!=null) {
			if(currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}else {
				TreeNode node = stack.pop();
				currNode = node.right;
				if(node == p) { 
					/* 1. node有右儿子 */
					if(node.right != null) {
						TreeNode m = node.right;
						/* 如果m节点还有左儿子，则successor为左儿子 */
						while(m.left != null) {
							m = m.left;
						}
						return m;
					}else {
						/* 2. node无右儿子，回溯上部节点并pop */
						if(!stack.isEmpty()) {
							TreeNode upperNode = stack.pop();
							return upperNode;
						}
					}
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(0);
		TreeNode p = new TreeNode(0);
		InorderSuccessorInBST bst = new InorderSuccessorInBST();
		System.out.println(bst.inorderSuccessor(tree, p).val);

	}

}
