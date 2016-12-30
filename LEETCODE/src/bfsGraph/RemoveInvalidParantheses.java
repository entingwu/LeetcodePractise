package bfsGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParantheses {
	//bfs
	//Exam all substings, starting from the original string 
	//Time complexity is O(n*2^n) because the need to invoke "valid" for very substring
	public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();//<string,frequency>
		queue.offer(s);//s="()())()"
		visited.add(s);
		int maxLength = 0;
		
		while(!queue.isEmpty()) {
			String curr = queue.poll();//s="()())()"
			if(validPair(curr)) {
				result.add(curr);//"(())()","()()()",
				maxLength = curr.length();
			}
			if(maxLength == 0) {//"[(())(), ()(), (()), (), ]"
				for(int i = 0; i < curr.length(); i++) {
					char ch = curr.charAt(i);
					if(ch == '(' || ch == ')') {//avoid a
						String next = curr.substring(0,i)+curr.substring(i+1);//next = curr remove ith character
						//next=")())()","(())()","()))()","()()()","()()()","()()))","()())("
						if(!visited.contains(next)) {
							queue.offer(next);//")())()" "(())()"
							visited.add(next);
						}
					}
				}
			}
		}
		return result;
    }
	
	private boolean validPair(String curr) {
		int left = 0, right = 0;
		for(int i = 0; i < curr.length(); i++) {
			char ch = curr.charAt(i);
			if(ch == '(') { left++; }
			if(ch == ')') { right++; }
			if(right > left) {
				return false;//()) left and right could not be a pair
			}
		}
		return left == right;//pair?
	}
	
	public static void main(String[] args) {
		String s = "()())()";
		String s1 = ")(";
		String s2 = "(a)())()";
		String s3 = "(())(()";
		RemoveInvalidParantheses rip = new RemoveInvalidParantheses();
		List<String> result = rip.removeInvalidParentheses(s3);
		System.out.println(result);
		
	}

}
