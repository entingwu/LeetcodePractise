package queueStack;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if(s == null || s.length() == 0) { return true; }
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}else {
				if(stack.isEmpty()){//]
					return false;
				}else{
					char top = stack.peek();
					if(top == '(' && ch == ')' || top == '[' && ch == ']' || top == '{' && ch == '}'){
						stack.pop();
					} else {// 一没配对就弹出
						return false;
					}	
				}
			}
		}
		return stack.isEmpty();//stack里不能有剩余"([{"
	}
	/* follow up */
	public boolean isValidI(String s) {
		if(s == null || s.length() == 0) { return true; }
		int ss = 0, m = 0, l = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch(ch) {
				case '(': ss++;
				          break;
				case '[': m++;
				          break;
				case '{': l++;
				          break;
				case ')': ss--; 
						  if(ss < 0) { return false; }
						  break;
				case ']': m--;
						  if(m < 0) { return false; }
						  break;
				case '}': l--;
						  if(l < 0) { return false; }
						  break;
			}
		}
		if(ss == 0 && m == 0 && l == 0) { 
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str = "([{])";
		String str1 = "()(()";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValidI(str1));
	}

}
