package queueStack;

import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		String result = "";
		if(path == null || path.length() == 0) { return result; }
		String[] str = path.split("/");
		Stack<String> stack = new Stack<String>();
		for(int i = 1; i < str.length; i++) {
			if(str[i].equals(".") || str[i].equals("")) {//"" 
				continue; 
			}else if(str[i].equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else {
				stack.push(str[i]);
			}
		}
		if(stack.isEmpty()) {
			result = "/";
		}
		while(!stack.isEmpty()) {
			result = "/" + stack.pop() + result; 
		}
		return result;
	}
	
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		String path = "/a/./b/../../c/";
		String path1 = "/../";
		String path2 = "/home//foo/";
		String result = sp.simplifyPath(path2);
		System.out.println(result);
	}

}
