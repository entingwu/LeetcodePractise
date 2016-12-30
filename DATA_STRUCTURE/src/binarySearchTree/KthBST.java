package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/* Problem 8 */
public class KthBST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;             // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
    public Node getRoot() { return root; }

    /**Initializes an empty symbol table.*/
    public KthBST() {}
    
 
    /** Problem 8.1. Find Minimum Key 
     *              Returns the smallest key in the symbol table.*/
    public Key minKey(Node x) {
    	if(x.left == null) { return x.key; }
    	return minKey(x.left);
    }
    
    /** Problem 8.2. Find kth smallest key 
     * @param  k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless k is between 0 and N-1
     * */
    public Key kthSmallKey(int k) {
    	if(k<0 || k>size()) { throw new NoSuchElementException(); }
    	Node node = kthSmallHelper(root, k);
    	return node.key;
    }
    private Node kthSmallHelper(Node x, int k) { // Return key of rank k.
    	if(x == null) { return null; }
    	int leftSize = size(x.left); 
    	if(k == leftSize+1) { return x; }
    	else if(k < leftSize+1) {
    		return kthSmallHelper(x.left, k);
    	}else {
    		return kthSmallHelper(x.right, k-leftSize-1);
    	}
    }
    
    // Helper : return number of key-value pairs in BST rooted at x
    public int size() { return size(root); }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
 
    /** Problem 8.3. Delete a node
     *               Removes the specified key and its associated value from this symbol table        
     */
    public void delete(Key key) {
    	if(key == null) { throw new NullPointerException("argument to delete() is null"); }
    	root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
    	if(x == null) { return null; }
    	int cmp = key.compareTo(x.key);
    	if     (cmp < 0) { x.left = delete(x.left, key); }
    	else if(cmp > 0) { x.right = delete(x.right, key); }
    	else {// ==
    		// 1. one son
    		if(x.left == null) { return x.right; } 
    		if(x.right == null) { return x.left; }
    		
    		// 2. two sons
    		Node t = x;//i. mark deleted node(t)
    		x = min(t.right);//ii. find the successor(x) of deleted node(t) 
    		x.right = deleteMin(t.right);//iii. delete successor(x) from the right subtree of deleted node(t)
    		x.left = t.left;//iv. left subtree == deleted node(t)'s left subtree
    	}
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }
    
    /**3. Helper : min && deleteMin
     *             Returns the smallest key in the symbol table.*/
    private Node min(Node x) { 
        if (x.left == null) { return x; } 
        else { return min(x.left); }
    } 
    
    /*Removes the smallest key and associated value from the symbol table.
      Returns a right subtree of node x without the min key 
      */
    public Node deleteMin(Node x) {// min at left side
    	if(x.left == null) { return x.right; }
    	x.left = deleteMin(x.left);
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }
    
    private Node insert(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = insert(x.left,  key, val);
        else if (cmp > 0) x.right = insert(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
 
    
    
    /* MAIN */
	public static void main(String[] args) {
		KthBST<Integer, Integer> st = new KthBST<Integer, Integer>();
		st.insert(5, 5);
		st.insert(4, 4); st.insert(16, 16);
		st.insert(1, 1); st.insert(10, 10); st.insert(17, 17);
		
		List<List<Integer>> result = st.levelOrder(st.getRoot());
		System.out.println(result);
		
		/* Problem 8.1. Find Minimum Key */
		int min = st.minKey(st.getRoot());
		System.out.println(min);
		
		/* Problem 8.2. Find kth smallest key */
		int ksk = st.kthSmallKey(5);
		System.out.println(ksk);
		
		/* Problem 8.3. Delete a node */
		st.delete(16);
		System.out.println(st.levelOrder(st.getRoot()));
	}
	
	
	
	
	
	
	/**4. Insert:
     * a. inserts the specified key-value pair into the symbol table, 
     *    overwriting the old value with the new value if the symbol table already contains the specified key.
     * b. Deletes the specified key (and its associated value) from this symbol table if the specified value is null.
     */
    public void insert(Key key, Value val) {
        if (key == null) throw new NullPointerException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        root = insert(root, key, val);
    }
	
    /**5. Level Order*/
    public List<List<Key>> levelOrder(Node x) {
    	List<List<Key>> result = new ArrayList<List<Key>>();
    	if(x == null) { return result; }
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.offer(x);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		List<Key> temp = new ArrayList<Key>();
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
