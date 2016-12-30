package dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		if(s == null || s.length() == 0) { return result; }
		partitionHelper(result, temp, s, 0);
		return result;
	}
	
	private void partitionHelper(List<List<String>> result, List<String> temp, String s, int pos) {
		if(pos == s.length()) {//插入位置为字符串长度，即搜索越界，结束
			result.add(new ArrayList<String>(temp));
			return;
		}
		for(int i = pos; i < s.length(); i++) {//pos为插入位置
			String sub = s.substring(pos, i + 1);//substring[pos,i+1) == substring[pos,i]. 
			if(isPalindrome(sub)) {
				temp.add(sub);
				partitionHelper(result, temp, s, i + 1);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	private boolean isPalindrome(String sub) {
		int i = 0, j = sub.length()-1;
		while(i < j) {
			if(sub.charAt(i) != sub.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "aab";
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> strs = pp.partition(s);
		System.out.println(strs);
	}

}
