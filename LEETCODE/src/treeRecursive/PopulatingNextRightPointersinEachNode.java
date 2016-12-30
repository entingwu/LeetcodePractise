package treeRecursive;

/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersinEachNode {

	public void connect(TreeLinkNode root) {
		// 空节点就直接返回  
		if(root == null) { return; }
		
		// 左节点非空，连接右节点
		if(root.left != null) {
        	root.left.next = root.right;
        }
		
		// 借助root.next处理5连6的情况
        if(root.right != null && root.next != null) {//2!=null && 2->3
        	root.right.next = root.next.left;//5->6
        }
		connect(root.left);
		connect(root.right);
    }
	
	public static void main(String[] args) {
		

	}

}
