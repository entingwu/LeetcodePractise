package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if(n == 0) { return result; }
		String str = new String();
		parenthesisHelper(result, str, n, n, n);
		return result;
	}
	
	private void parenthesisHelper(List<String> result, String str, int left, int right, int n) {
		if(left == 0 && right == 0) {
			result.add(str);
			return;
		}
		if(left > 0) {
			str = str + "(";
			parenthesisHelper(result, str, left-1, right, n);
			str = str.substring(0, str.length()-1);
		}
		if(right > 0 && right > left) {
			str = str + ")";
			parenthesisHelper(result, str, left, right-1, n);
			str = str.substring(0, str.length()-1);
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		GenerateParentheses gp = new GenerateParentheses();
		List<String> list = gp.generateParenthesis(n);
		System.out.println(list);
		
	}

}
