package treeRecursive;

public class RemoveNodeInBST {
	/* 在以root为首的tree中delete一个值为value的node */
	public TreeNode removeNode(TreeNode root, int value) {
        TreeNode x = root;
        if (x == null) { return x; }
        if (x.val > value) {//left sub tree
        	x.left = removeNode(x.left, value);//root不变，连接上在以x.left为首的子树中delete一个值为value的node的子树
        } else if (x.val < value) {//right sub tree
        	x.right =  removeNode(x.right, value);
        } else {
        	/*1. one son */
        	if(x.left == null) { return x.right; }
        	if(x.right == null) { return x.left; }
        	
        	/*2. two sons */
        	TreeNode t = x;//mark deleted node t.
        	x = min(t.right);//find the successor of deleted node t
        	x.right = deleteMin(t.right);
        	x.left = t.left; 
        }
        return x;
    }
	
	/* Returns a right sub tree of node x without the min key */
	private TreeNode deleteMin(TreeNode x) {
		if (x.left == null) { return x.right; }
		x.left = deleteMin(x.left);
		return x;
	}
	
	private TreeNode min(TreeNode x) {
		if (x.left == null) { return x; }//buttom
		return min(x.left);
	}
	
	public static void main(String[] args) {
		

	}

}
