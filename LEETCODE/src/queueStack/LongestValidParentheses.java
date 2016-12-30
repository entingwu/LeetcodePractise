package queueStack;

import java.util.Stack;

public class LongestValidParentheses {
	/**
	 *  0  1  2  3  4  5
	 * ")  (  )  (  )  )"
	 * */
	public int longestValidParentheses(String s) {
		int prev = -1;//validparenthese组合前一位的index
		int maxLength = 0;
		Stack<Integer> stack = new Stack<Integer>();//'('的index
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);//left
			}else {//')'
				if(stack.isEmpty()) {//证明该')'为invalid，记录下其index作为validparenthese的前序
					prev = i;	//0
				}else {//'()'
					int prevIndex = stack.pop();//i=2
					if(stack.isEmpty()) {
						maxLength = Math.max(maxLength, i-prev);//i=2: 2-0=2; i=4: 4-0=4
					}else {
						maxLength = Math.max(maxLength, i-stack.peek());//"(()"
					}
				}
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		String s = "(()())";
		System.out.println(lvp.longestValidParentheses(s));

	}

}
