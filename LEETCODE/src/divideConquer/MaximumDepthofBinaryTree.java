package divideConquer;

import java.util.*;

import binarySearchTree.TreeNode;

class TreeNode1{
	public int val;
	public TreeNode1 left;
	public TreeNode1 right;
	public TreeNode1(int num){
		val = num;
		left = null;
		right = null;
	}
}
class Tree1{
	public TreeNode1 root;
	public Tree1(){
		root = null;}
	/* Path Sum */
	public boolean hasPathSum(TreeNode root, int sum){
		return PathSumHelper(root, 0, sum);
	}
	public boolean PathSumHelper(TreeNode root, int sum, int target){
		if(root == null){ return false; }
		sum += root.val;//??????????????????????????????
		if(root.left == null && root.right == null){//leaf???????????????????????????
			if(sum == target){
				return true;
			}else{
				return false;
			}
		}
		return PathSumHelper(root.left, sum, target)
			   || PathSumHelper(root.right, sum, target);
	}
	
	/* Path Sum II */
	public List<List<Integer>> pathSumII(TreeNode root, int sum){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tempResult = new ArrayList<Integer>();
		if(root == null){ return result; }
		findSum(result, tempResult, root, 0, sum);
		return result;
	}
	public void findSum(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum, int target){
		
		sum += root.val;
		temp.add(root.val);
		if(root.left == null && root.right == null){
			if(sum == target){
				result.add(temp);
			}
		}
		if(root.left != null){ findSum(result, temp, root.left, sum, target); }
		if(root.right != null){ findSum(result, temp, root.right, sum, target); }
		temp.clear();
	}
	/* sum root to leaf numbers */
	public int sumNumbers(TreeNode root){
		if(root == null){ return 0;}
		return generateSum(root, 0);
	}
	public int generateSum(TreeNode root, int val){
		if(root.left == null && root.right == null){
			val = val * 10 + root.val;
			return val;
		}
		int left = 0;
		int right = 0;
		val = val * 10 + root.val;
		if(root.left != null){
			left = generateSum(root.left, val);
		}
		if(root.right != null){
			right = generateSum(root.right, val);
		}
		return left + right;
	}
	/* MaxDepth */
	public int maxDepth(TreeNode1 root) {
        if(root == null){ return 0; }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right);
    }
	/* MinDepth */
	public int minDepth(TreeNode root){
		if(root == null){ return 0; }
		return getMin(root);
	}
	public int getMin(TreeNode root){
		if(root == null){ return Integer.MAX_VALUE; }//????????????
		if(root.left == null && root.right == null){
			return 1;
		}
		return Math.min(getMin(root.left), getMin(root.right))+1;
	}
	
	/* isSameTree */
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null){ return true; }
		if(p != null && q != null){
			if(p.val == q.val){//???????????????????????????????????????????????????????????????????????????????????????
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}else{
				return false;
			}
		}
		return false;
	}
	
	/* lowestCommonAncestor */
	public TreeNode1 lowestCommonAncestor(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
	    //???root????????????????????????A,B???LCA:
		//??????????????????????????????LCA
		//???????????????A????????????A
		//???????????????B????????????B
		//???????????????????????????null
		if(root == null || root == p || root == q){
			return root;
		}
		
		//Divide
		TreeNode1 left = lowestCommonAncestor(root.left, p, q);
		TreeNode1 right = lowestCommonAncestor(root.right, p, q);
		
		//Conquer
		if(left != null && right != null){
			return root;
		}
		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}
		return null;
    }
	
	/*public boolean hasPathSum(TreeNode root, int sum){
	if(root == null){ return false;}
	if(root.left == null && root.right == null){
		return root.val == sum; 
	}
	boolean isLeft = false;
	boolean isRight = false;
	if(root.left != null){
		isLeft = hasPathSum(root.left, sum - root.val);
	}
	if(root.right != null){
		isRight = hasPathSum(root.right, sum - root.val);
	}
	return isLeft || isRight;
}*/
}

public class MaximumDepthofBinaryTree {
	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(3);
		TreeNode1 p = new TreeNode1(5);
		TreeNode1 q = new TreeNode1(1);
		root.left = p;
		root.right = q;
		Tree1 tree = new Tree1();
		System.out.println(tree.lowestCommonAncestor(root,p,q).val);
	}
}
