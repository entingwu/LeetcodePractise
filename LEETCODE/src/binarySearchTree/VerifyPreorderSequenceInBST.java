package binarySearchTree;

import java.util.Stack;

public class VerifyPreorderSequenceInBST {

	public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for(int i : preorder) {
            if(low > i) {
                return false;
            }
            while(!stack.isEmpty() && i > stack.peek()) {//i大，把stack里小的元素pop出来
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
	
	public static void main(String[] args) {
		

	}

}
