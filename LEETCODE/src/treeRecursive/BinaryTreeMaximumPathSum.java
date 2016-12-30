package treeRecursive;

public class BinaryTreeMaximumPathSum {
	
	private class ResultType {
		int rootToAny;
		int anyToAny;
		ResultType(int rootToAny, int anyToAny) {
			this.rootToAny = rootToAny;
			this.anyToAny = anyToAny;
		}
	}
	
	public int maxPathSum(TreeNode root) {
		ResultType result = helper(root);
		return result.anyToAny;
	}
	
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
		}
		/*1. Divide*/
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		/*2. Conquer*/
		int rootToAny = 
				Math.max(0, Math.max(left.rootToAny, right.rootToAny)) + root.val;
		//left or right
		int anyToAny = Math.max(left.anyToAny, right.anyToAny);
		anyToAny = Math.max(anyToAny, 
				Math.max(left.rootToAny, 0) + 
				Math.max(right.rootToAny, 0) + root.val);
		return new ResultType(rootToAny, anyToAny);
    }
	
	public static void main(String[] args) {
		

	}

}
