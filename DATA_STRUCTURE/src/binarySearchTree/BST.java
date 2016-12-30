package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST<Key extends Comparable<Key>, Value> {
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
    public BST() {}
    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
 
    
    /**1. Search : Returns the value associated with the given key.*/
    public Value search(Key key) {
        return search(root, key);
    }
    private Value search(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return search(x.left, key);
        else if (cmp > 0) return search(x.right, key);
        else              return x.val;
    }
    
    /**2. Insert:
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
    private Node insert(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = insert(x.left,  key, val);
        else if (cmp > 0) x.right = insert(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**3. Delete
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
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
     * Returns the smallest key in the symbol table.*/
    private Node min(Node x) { 
        if (x.left == null) { return x; } 
        else { return min(x.left); }
    } 
    
    /*Removes the smallest key and associated value from the symbol table.
      Returns a right subtree of node x without the min key */
    public Node deleteMin(Node x) {// min at left side
    	if(x.left == null) { return x.right; }
    	x.left = deleteMin(x.left);
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }
    
    /**4. Level Order*/
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

    /**5.Height
     *   Returns the height of the BST */
    public int height(Node x) {
    	if(x == null) { return -1; }
    	return 1 + Math.max(height(x.left), height(x.right));
    }
    
    /* Problem 4 */
    public Key random_key() {
    	return random_key(root);
    }
    private Key random_key(Node x) {
    	if(x == null) { return null; }
    	int random = (int)(Math.random()*size(x)+1);//1~size
    	if(random == size(x.left)+1) {
    		return x.key;
    	}else if(random < size(x.left)+1) {
    		return random_key(x.left);
    	}else {
    		return random_key(x.right);
    	}
    }
    
    /* Problem 5 */
    public List<Key> treeSort(LinkedHashMap<Key,Value> map) {
    	for(Key key : map.keySet()) {
    		insert(key, map.get(key));
    	}
    	return inorder(root);
    }
    public List<Key> inorder(Node root) {
    	List<Key> result = new ArrayList<Key>();
    	if(root == null) { return result; }
    	Stack<Node> stack = new Stack<Node>();
    	Node currNode = root;
    	while(!stack.isEmpty() || currNode!=null) {
    		if(currNode!=null) {
    			stack.push(currNode);
    			currNode = currNode.left;
    		}else {
    			Node node = stack.pop();
    			result.add(node.key);
    			currNode = node.right;
    		}
    	}
    	return result;
    }
    
    /* Problem 7 : IsBST */
    public boolean isBST(Node x) {
    	return isBST(x, null, null);
    }
    private boolean isBST(Node x, Key min, Key max) {
    	if(x == null) { return true; }
    	if(min != null && x.key.compareTo(min) <= 0) {
    		return false;
    	}
    	if(max != null && x.key.compareTo(max) >= 0) {
    		return false;
    	}
    	return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }
    
	public static void main(String[] args) {
		BST<Integer, Integer> st = new BST<Integer, Integer>();
		/*st.insert(5, 5);
		st.insert(4, 4); st.insert(16, 16);
		st.insert(1, 1); st.insert(10, 10); st.insert(17, 17);
		st.insert(21, 21);*/
		
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(5, 5);
		map.put(4, 4); map.put(16, 16);
		map.put(1, 1); map.put(10, 10); map.put(17, 17);
		map.put(21, 21);
		List<Integer> sort = st.treeSort(map);
		List<List<Integer>> result = st.levelOrder(st.getRoot());
		System.out.println(result);
		System.out.println(sort);
		
		Integer random_key = st.random_key();
		//System.out.println(random_key);
		
		/* Problem 7 IsBST*/
		System.out.println(st.isBST(st.getRoot()));
	}

}
