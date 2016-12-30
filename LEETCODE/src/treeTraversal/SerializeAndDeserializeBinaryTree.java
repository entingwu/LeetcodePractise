package treeTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SerializeAndDeserializeBinaryTree {
	/* Preorder */
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null) { return sb.toString(); }
		preorderSerialize(root, sb);
		return sb.toString();
	}
	
	private void preorderSerialize(TreeNode node, StringBuilder sb) {
		if(node == null) { 
			sb.append("# ");
			return;
		}
		sb.append(node.val).append(" ");
		preorderSerialize(node.left, sb);
		preorderSerialize(node.right, sb);
	}
	/* Deserialize */
	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0) { return null; }
		String[] strArray = data.split(" ");
		int[] index = {0};
		return preorderDeserialize(strArray, index);
	}
	
	private TreeNode preorderDeserialize(String[] str, int[] index) {
		if(index[0] >= str.length) { return null; }
		String val = str[index[0]++];
		if(val.equals("#")) { return null; }
		
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = preorderDeserialize(str, index);
		node.right = preorderDeserialize(str, index);
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		SerializeAndDeserializeBinaryTree sdb = new SerializeAndDeserializeBinaryTree();
		String tree = sdb.serialize(node1);
		System.out.println(tree);
		
		TreeNode root = sdb.deserialize(tree);
		String result = sdb.serialize(root);
		System.out.println(result);
		
		/* string spilt */
		/*string[] strArray = tree.split(",#");
		for(string i : strArray) {
			System.out.print(i + " ");
		}*/

		
	}
	public String serializeLevel(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null) { return sb.toString(); }
		sb.append("[");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node == null) {
				sb.append("#").append(",");
				continue;
			}else{
				sb.append(node.val).append(",");
			}
			queue.offer(node.left);
			queue.offer(node.right);
		}
		sb.append("]");
		return sb.toString();
	}
	
	/* StringTokenizer Deserialize */
	public TreeNode deserialize1(String data) {
		if(data == null || data.length() == 0) { return null; }
		StringTokenizer str = new StringTokenizer(data);
		return preorderDeserialize1(str);
	}
	
	private TreeNode preorderDeserialize1(StringTokenizer str) {
		if(str.countTokens() == 0) { return null; }
		String val = str.nextToken();
		if(val.equals("#")) { return null; }
		
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = preorderDeserialize1(str);
		node.right = preorderDeserialize1(str);
		return node;
	}
}
