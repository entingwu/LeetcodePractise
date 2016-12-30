package treeTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
	
	private class TreeNodeCol {
		TreeNode treeNode;
		int col;
		public TreeNodeCol(TreeNode node, int col) {
			this.treeNode = node;
			this.col = col;
		}
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) { return result; }
        /*A. key:col, value:List<Integer>*/
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        Queue<TreeNodeCol> queue = new LinkedList<TreeNodeCol>();
        queue.offer(new TreeNodeCol(root, 0));
        
        /* currLevel,nextLevel用以标注同一水平层的node数
         * 			(7,2) (2,0) (5,0) (4,-2)
         * nextLevel : 4	3	  2		1
         *          max2  min0   max0  min-2 * */
        int currLevel = 1;
        int nextLevel = 0;
        int max = 0, min = 0;//记录vertical最高最低层，用于最后循环加入result 
        
        /*B. LEVEL ORDER*/
        while(!queue.isEmpty()) {
        	/*1.node*/
        	TreeNodeCol nodeCol = queue.poll();
        	if(map.containsKey(nodeCol.col)) {//col already exist
        		map.get(nodeCol.col).add(nodeCol.treeNode.val);
        	}else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(nodeCol.treeNode.val);
        		map.put(nodeCol.col, list);
        	}
        	currLevel--;
        	/*2.node.left : min*/
        	if(nodeCol.treeNode.left != null) {
        		TreeNodeCol left = new TreeNodeCol(nodeCol.treeNode.left, nodeCol.col-1);
        		queue.offer(left);
        		nextLevel++;
        		min = Math.min(nodeCol.col-1, min);
        	}
        	/*3.node.right : max*/
        	if(nodeCol.treeNode.right != null) {
        		TreeNodeCol right = new TreeNodeCol(nodeCol.treeNode.right, nodeCol.col+1);
        		queue.offer(right);
        		nextLevel++;
        		max = Math.max(nodeCol.col+1, max);
        	}
        	/*4.currLevel, nextLevel*/
        	if(currLevel == 0) {
        		currLevel = nextLevel;//当前水平层有多少个node
        		nextLevel = 0;
        	}
        }
        
        /*C. col,List<TreeNodeCol> -> List<Integer> using col as order*/
        for(int i = min; i <= max; i++) {//i == key
        	List<Integer> list = map.get(i);
        	result.add(list);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		BinaryTreeVerticalOrderTraversal bt = new BinaryTreeVerticalOrderTraversal();
		List<List<Integer>> result =  bt.verticalOrder(node1);
		System.out.println(result);

	}

}
