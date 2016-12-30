package binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PreorderBST {
    private Node root;             // root of BST

    private class Node {
        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees
        
        public Node(int key) {
            this.key = key;
        }
    }
 
    /* Problem 6 : O(n)*/
    private int index = 0;
    public Node constructTree(int[] pre, int size) {
    	int index = 0;
    	return constructTreeHelper(pre, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }
    
    /* A recursive function to construct BST from pre[]. 
     * global variable index is used to keep track of index in pre[]. */
    private Node constructTreeHelper(int[] pre, int key, int min, int max, int size) {
    	
    	/* 1. Base case */
    	if(index >= size) { return null; }
    	Node node = null;
    	
    	// If current element of pre[] is in range, then only it is part of current subtree
    	if(min<key && key< max) {
    		// Allocate memory for root of this subtree and increment index
    		node = new Node(key);
    		index = index + 1;
    		
    		if(index < size) {
    			// Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
    			node.left = constructTreeHelper(pre, pre[index], min, key, size);
    			
    			// All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
    			node.right = constructTreeHelper(pre, pre[index], key, max, size);
    		}
    	}
    	
    	return node;
    }
    
    /* Problem 6 : O(n^2)*/
    public Node buildTree(int[] preorder, int[] inorder) {
		return preInorderBST(preorder, inorder, 0, 0, inorder.length-1);
	}
    private Node preInorderBST(int[] preorder, int[] inorder, int prePos, int startIn, int endIn) {
    	if(startIn > endIn) { return null; }
    	/* 1. root */
    	Node root = new Node(preorder[prePos]);
    	
    	/* 2. spilt inorder[] */
    	int split = 0;//split is the size of left subtree
    	for(int i = startIn; i <= endIn; i++) {
    		if(preorder[prePos] == inorder[i]) {
    			split = i;
    			break;
    		}
    	}
    	/* 3. dfs */
    	/* preorder[prePos+1], inorder[startIn] ~ inorder[spilt-1] */
    	root.left = preInorderBST(preorder, inorder, prePos+1, startIn, split-1);
    	/* preorder[prePos + spilt - startIn + 1], inorder[spilt + 1] ~ inorder[endIn] */
    	root.right = preInorderBST(preorder, inorder, prePos+1+split-startIn, split+1, endIn);
    	
    	return root;
    }
    
    /* Problem 7 : IsBST O(n)
     *             Returns true if given search tree is binary search tree */
    private int preKey = Integer.MIN_VALUE; 
    private boolean isFirst = true;//处理只有一个node
    public boolean isBST(Node node) {
    	if(node == null) { return true; }
    	/* 1. left */
    	if(!isBST(node.left)) {
    		return false;
    	}
    	
    	/* 2. middle 
    	 *    Traverse the tree in inorder fashion and keep a track of previous node
    	 *    Allows only distinct valued nodes */
    	if(!isFirst && node.key <= preKey) {
    		//防止Integer.MIN_VALUE>=root.val == -2147483648的corner case
    		return false;
    	}
    	isFirst = false;//第二次出现
    	preKey = node.key;
    	
    	/* 3. right */
    	if(!isBST(node.right)) {
    		return false;
    	}
    	return true;
    }
    
    /* Problem 7.1 : IsBST O(n)*/
    public boolean IsBST(Node node) {
    	return IsBSThelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    /* Returns true if the given tree is a BST and its values are >= min and <= max. */
    private boolean IsBSThelper(Node node, int min, int max) {
    	//1. empty tree
    	if(node == null) { return true; }
    	
    	//2. node
    	if(min > node.key || node.key > max) { return false; }
    	
    	//3. left right subtree
    	return IsBSThelper(node.left, min, node.key-1) && IsBSThelper(node.right, node.key+1, max);
    }
    
	public static void main(String[] args) {
		/* Problem 6 : O(n) */
		PreorderBST st = new PreorderBST();
		int[] array = { 5, 4, 1, 16, 10, 17, 21 };
		Node root = st.constructTree(array, array.length);
		List<List<Integer>> result = st.levelOrder(root);
		System.out.println(result);
		
		/* Problem 6 : O(n^2) */
		int[] preorder = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			preorder[i] = array[i];
		}
		Arrays.sort(array);//inorder
		Node newRoot = st.buildTree(preorder, array);
		List<List<Integer>> result1 = st.levelOrder(newRoot);
		System.out.println(result1);
		
		/* Problem 7 */
		boolean isBST = st.isBST(newRoot);
		System.out.println(isBST);
		
		System.out.println(st.IsBST(newRoot));
		
	}
	
    /**Level Order*/
    public List<List<Integer>> levelOrder(Node x) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(x == null) { return result; }
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.offer(x);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> temp = new ArrayList<Integer>();
    		for(int i = 0; i < size; i++) {
    			Node node = queue.poll();
    			temp.add(node.key);
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
