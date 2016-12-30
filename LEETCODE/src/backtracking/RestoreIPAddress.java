package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) { 
			return result; 
		}
		dfs(result, temp, s, 0, s.length());
		return result;
	}
	
	private void dfs(List<String> result, List<String> temp, String s, int index, int len) {
		if (temp.size() == 4 && index == len) {
			StringBuilder sb = new StringBuilder();
			for(String part : temp) {
				sb.append(part);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
		}
		for(int i = index; i < index + 3 && i < len; i++) {// index, i
			String str = s.substring(index, i+1);
			if (str.charAt(0) == '0' && i > index) {//除去"0.1.001.0"，只允许单个0
				break;
			}
			int num = Integer.parseInt(str);
			if (num > 255) {
				continue;
			}
			temp.add(str);
			dfs(result, temp, s, i+1, len);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddress rip = new RestoreIPAddress();
		String s = "25525511135";
		String s1 = "010010";
		List<String> result = rip.restoreIpAddresses(s1);
		System.out.println(result);
	}

}
