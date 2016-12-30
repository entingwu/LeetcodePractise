package binarySearchTree;

class Key {
	int k;
	public int compareTo(Key key) {
		return this.k - key.k;
	}
}
class Value {
	int v;
	public int compareTo(Value value) {
		return this.v - value.v;
	}
}
class TreeNode<Key,Value> {
	Key key;
	Value value;
	TreeNode<Key,Value> left;
	TreeNode<Key,Value> right;
	public TreeNode(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
}

public class SearchInsertBST {
	/* 1. Search */
	public static Value search(Key key, TreeNode<Key,Value> root) {
		if(root == null) { return null; }
		int cmp = key.compareTo(root.key);
		if(cmp == 0) { 
			return root.value; 
		}else if(cmp < 0) { 
			search(key, root.left); 
		}else {//key > root.key
			search(key, root.right);
		}
		return null;
	}
	
	/* 2. Insert */
	public TreeNode<Key,Value> insert(Key key, Value value, TreeNode<Key,Value> root) {
		if(root == null) { return new TreeNode<Key,Value>(key, value); }
		int cmp = key.compareTo(root.key);
		if(cmp == 0) {
			root.value = value;
		}else if(cmp < 0) {//key < root.key
			root.left = insert(key, value, root.left);
		}else {
			root.right = insert(key, value, root.right);
		}
		return root;
	}
	
	
	public static void main(String[] args) {
		

	}

}
